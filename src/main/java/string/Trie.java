package string;

/**
 * 实现一个字符集，只包含 A-Z 这26个字母的 Trie 数
 *
 * @author:hxd
 * @date:2019/11/8
 */
public class Trie {
    private TrieNode root = new TrieNode('/');

    /**
     * 插入字符串
     *
     * @param text
     */
    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        // 表示该字符为字符串结束字符
        p.isEndingChar = true;
    }

    /**
     * 查找字符串看是否存在
     *
     * @param text
     * @return
     */
    public Boolean find(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        // 避免其他字符串前缀误判
        return p.isEndingChar;
    }

    class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isEndingChar = false;

        TrieNode(char data) {
            this.data = data;
        }
    }
}
