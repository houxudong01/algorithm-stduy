//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 题目编号：501
// https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
@SuppressWarnings("all")
public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
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

    class Solution {
        // 当前值已重复数
        private int curCnt = 1;
        // 最大重复数
        private int maxCnt = 1;
        private TreeNode preNode = null;
        private List<Integer> nums = new ArrayList<>();

        public int[] findMode(TreeNode root) {
            inOrder(root);
            int[] array = new int[nums.size()];
            for (int i = 0; i < nums.size(); i++) {
                array[i] = nums.get(i);
            }
            return array;
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            if (preNode != null) {
                if (preNode.val == root.val) {
                    curCnt++;
                } else {
                    curCnt = 1;
                }
            }
            if (curCnt > maxCnt) {
                maxCnt = curCnt;
                nums.clear();
                nums.add(root.val);
            } else if (curCnt == maxCnt) {
                nums.add(root.val);
            }
            preNode = root;
            inOrder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}