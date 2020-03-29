//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 示例: 
//
// 输入: "25525511135"
//输出: ["255.255.11.135", "255.255.111.35"] 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// 题目编号：93
// https://leetcode-cn.com/problems/restore-ip-addresses/
@SuppressWarnings("all")
public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        String s = "25525511135";
        List<String> strings = solution.restoreIpAddresses(s);
        System.out.println(strings);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            dfs(0, new StringBuilder(), res, s);
            return res;
        }

        private void dfs(int k, StringBuilder tempAddress, List<String> res, String s) {
            if (k == 4 || s.length() == 0) {
                if (k == 4 && s.length() == 0) {
                    res.add(tempAddress.toString());
                }
                return;
            }
            for (int i = 0; i < s.length() && i <= 2; i++) {
                // 大于一位数时0不能为头
                if (i != 0 && s.charAt(0) == '0') {
                    return;
                }
                String part = s.substring(0, i + 1);
                // ip每一段占4位，最大可以表示255
                if (Integer.valueOf(part) > 255) {
                    continue;
                }
                if (tempAddress.length() != 0) {
                    part = "." + part;
                }
                tempAddress.append(part);
                dfs(k + 1, tempAddress, res, s.substring(i + 1));
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}