//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树

package leetcode.editor.cn;

// 题目编号：208
// https://leetcode-cn.com/problems/implement-trie-prefix-tree/
@SuppressWarnings("all")
public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
    }

    static class TrieNode {
        /**
         * 节点值
         */
        char data;
        /**
         * 该节点值是否是最后一个字符
         */
        boolean isEndChar = false;
        /**
         * 当前节点的子节点
         */
        TrieNode[] children = new TrieNode[26];

        TrieNode(char data) {
            this.data = data;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    static class Trie {
        /**
         * 根节点
         */
        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode('/');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode p = root;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (p.children[index] == null) {
                    TrieNode newNode = new TrieNode(chars[i]);
                    p.children[index] = newNode;
                }
                p = p.children[index];
            }
            p.isEndChar = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode p = root;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
            }
            return p.isEndChar;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            char[] chars = prefix.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)


}