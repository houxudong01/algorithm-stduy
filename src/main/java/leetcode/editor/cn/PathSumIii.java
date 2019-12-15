//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树

package leetcode.editor.cn;

// 题目编号：437
// https://leetcode-cn.com/problems/path-sum-iii/
@SuppressWarnings("all")
public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 双重递归，先先序遍历，然后以每一个节点为根节点去寻找
    class Solution {
        int count = 0;

        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            preOrder(root, sum);
            return count;
        }

        private TreeNode preOrder(TreeNode root, int sum) {
            if (root == null) {
                return root;
            }
            recurse(root, sum);
            preOrder(root.left, sum);
            preOrder(root.right, sum);
            return root;
        }

        private void recurse(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            if (root.val == sum) {
                count++;
            }
            recurse(root.left, sum - root.val);
            recurse(root.right, sum - root.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}