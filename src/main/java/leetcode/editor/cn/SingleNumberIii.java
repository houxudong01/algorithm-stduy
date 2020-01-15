//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。 
//
// 示例 : 
//
// 输入: [1,2,1,3,2,5]
//输出: [3,5] 
//
// 注意： 
//
// 
// 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。 
// 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
// 
// Related Topics 位运算


package leetcode.editor.cn;

// 题目编号：260
// https://leetcode-cn.com/problems/single-number-iii/
@SuppressWarnings("all")
public class SingleNumberIii {
    public static void main(String[] args) {
        Solution solution = new SingleNumberIii().new Solution();
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        System.out.println(solution.singleNumber(nums));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumber(int[] nums) {
            int diff = 0;
            for (int num : nums) {
                diff ^= num;
            }
            diff &= -diff;
            int[] res = new int[2];
            for (int num : nums) {
                if ((num & diff) == 0) {
                    res[0] ^= num;
                } else {
                    res[1] ^= num;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}