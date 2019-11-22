package study.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 实现一个二叉查找树
 *
 * @author:hxd
 * @date:2019/11/9
 */
public class BinarySearchTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 插入
     *
     * @param value
     * @return
     */
    public int insert(int value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null) {
            root = newNode;
        }
        TreeNode cur = root;

        while (cur != null) {
            if (value == cur.data) {
                return -1;
            } else if (value < cur.data) {
                if (cur.left == null) {
                    cur.left = newNode;
                    return value;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = newNode;
                    return value;
                }
                cur = cur.right;
            }
        }
        return -1;
    }

    /**
     * 查找
     *
     * @param value
     * @return
     */
    public int search(int value) {
        if (root == null) {
            return -1;
        }
        TreeNode cur = root;

        while (cur != null) {
            if (value == cur.data) {
                return value;
            } else if (value < cur.data) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return -1;
    }

    /**
     * 删除
     * 注意：删除可分三种情况
     * 1.删除叶子节点，让其父节点子节点指针置 null 即可
     * 2.删除只有一个子树的节点，把子树节点挂在到父节点上即可
     * 3.删除有两个子树的节点，找到要删除节点右子树上的最小节点（即最左节点），代替要删除的节点即可
     *
     * @param value
     * @return
     */
    public int remove(int value) {
        if (root == null) {
            return -1;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        // 当前节点是父节点的左子树还是右子树
        boolean isLeft = false;

        while (cur != null) {
            if (value == cur.data) {
                break;
            } else if (value < cur.data) {
                parent = cur;
                cur = cur.left;
                isLeft = true;
            } else {
                parent = cur;
                cur = cur.right;
                isLeft = false;
            }
        }
        // 没找到节点
        if (cur == null) {
            return -1;
        }

        // 要删除的节点是叶子节点
        if (cur.left == null && cur.right == null) {
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // 要删除的节点仅有左子树或右子树
        else if (cur.left == null || cur.right == null) {
            // 唯一的子树节点
            TreeNode onlyOneChild = cur.left == null ? cur.right : cur.left;
            if (isLeft) {
                parent.left = onlyOneChild;
            } else {
                parent.right = onlyOneChild;
            }
        }
        // 要删除的节点左右两个子树都存在，那么要用右子树的最小节点放到要删除的节点位置
        else {
            // 右子树最左子节点的父节点
            TreeNode rightMinP = parent;
            // 右子树最左子节点
            TreeNode rightMin = cur.right;

            // 查找到要移除节点的右子树上的最小节点（最左子节点）
            while (rightMin != null) {
                if (rightMin.left != null) {
                    rightMinP = rightMin;
                    rightMin = rightMin.left;
                } else {
                    break;
                }
            }

            // 如果最左子树存在右子树，把最左子树的右子树挂到其父节点左子树上
            if (rightMin.right != null) {
                rightMinP.left = rightMin.right;
            }
            // 无右子树
            else {
                rightMinP.left = null;
            }
            // parent == null 说明是要删除根节点，需要修改 root 的引用
            if (parent != null) {
                if (isLeft) {
                    parent.left = rightMin;
                } else {
                    parent.right = rightMin;
                }
            } else {
                root = rightMin;
            }
            // 把要删除节点的左右子树挂载到此位置的新节点上
            rightMin.left = cur.left;
            rightMin.right = cur.right;
        }
        return cur.data;
    }

    /**
     * 先序遍历
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "->");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        System.out.print(root.data + "->");
        midOrder(root.right);
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "->");
    }

    /**
     * 分层遍历
     *
     * @param root
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        // 存放每层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            // 存放每层的节点data
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            result.add(list);
        }

        // 分层打印出来
        for (List<Integer> list : result) {
            for (Integer data : list) {
                System.out.print(data + " ");
            }
            System.out.println();
        }

        return result;
    }

    /**
     * 获取二叉查找树的高度
     *
     * @param root
     * @return
     */
    public int getTreeHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        // 没有左右子树的节点的高度是 0
        if (root.left == null && root.right == null) {
            return 0;
        }
        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
    }

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }
}
