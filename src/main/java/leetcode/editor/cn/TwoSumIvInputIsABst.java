//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 案例 1: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
// 
//
// 
//
// 案例 2: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
// 
//
// 
// Related Topics 树

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 题目编号：653
// https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
@SuppressWarnings("all")
public class TwoSumIvInputIsABst {
    public static void main(String[] args) {
        Solution solution = new TwoSumIvInputIsABst().new Solution();
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
        private List<Integer> nums = new ArrayList<>();

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            inOrder(root);
            int i = 0;
            int j = nums.size() - 1;
            while (i < j) {
                int sum = nums.get(i) + nums.get(j);
                if (sum == k) {
                    return true;
                }
                if (sum < k) {
                    i++;
                } else {
                    j--;
                }
            }
            return false;
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            nums.add(root.val);
            inOrder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}