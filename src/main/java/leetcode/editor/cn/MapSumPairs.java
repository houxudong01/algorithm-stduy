//实现一个 MapSum 类里的两个方法，insert 和 sum。 
//
// 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。 
//
// 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。 
//
// 示例 1: 
//
// 输入: insert("apple", 3), 输出: Null
//输入: sum("ap"), 输出: 3
//输入: insert("app", 2), 输出: Null
//输入: sum("ap"), 输出: 5
// 
// Related Topics 字典树

package leetcode.editor.cn;

// 题目编号：677
// https://leetcode-cn.com/problems/map-sum-pairs/
@SuppressWarnings("all")
public class MapSumPairs {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("app"));
    }

    static class TrieNode {
        /**
         * 键的一个字符
         */
        char keyChar;
        /**
         * 键对应的value值，此字段只有key是传入键的最后一个字符时有效
         */
        int value;
        /**
         * keyChar 是否是键字符串的最后一个字符
         */
        boolean isEndChar = false;
        /**
         * 子节点
         */
        TrieNode[] children = new TrieNode[26];

        TrieNode(char keyChar) {
            this.keyChar = keyChar;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    static class MapSum {
        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new TrieNode('/');
        }

        public void insert(String key, int val) {
            TrieNode p = root;
            char[] chars = key.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (p.children[index] == null) {
                    TrieNode newNode = new TrieNode(chars[i]);
                    p.children[index] = newNode;
                }
                p = p.children[index];
            }
            // 将value值保存在 key字符串最后一个字符 所在的节点上
            p.value = val;
            p.isEndChar = true;
        }

        public int sum(String prefix) {
            TrieNode p = root;
            char[] chars = prefix.toCharArray();
            // 遍历找到传入前缀的最后一个字符所在的节点
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                // 不存在以此前缀开头的键，直接返回
                if (p.children[index] == null) {
                    return 0;
                }
                p = p.children[index];
            }
            // 从 前缀字符串 的最后一个字符所在的节点开始深度遍历，累加所有 endChar 节点的和
            return dfs(p);
        }

        /**
         * 深度遍历 trie 树，累加所有 endChar 节点的和
         *
         * @param p
         * @return
         */
        private int dfs(TrieNode p) {
            int sum = 0;
            if (p.isEndChar) {
                sum += p.value;
            }
            for (TrieNode childNode : p.children) {
                if (childNode != null) {
                    sum += dfs(childNode);
                }
            }
            return sum;
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)


}