package string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * AC 自动机算法，多模式串匹配算法实现
 * 可用于过滤敏感词，将敏感词构建 AC 自动机，包括构建 Trie 树和构建失败指针
 * 感谢 @王铮老师 实现
 *
 * @author:hxd
 * @date:2019/11/8
 */
public class AhoCorasick {
    private AcNode root = new AcNode('/');

    class AcNode {
        public char data;
        public AcNode[] children = new AcNode[26]; // 字符集只包含a~z这26个字符
        public boolean isEndingChar = false; // 结尾字符为true
        public int length = -1; // 当isEndingChar=true时，记录模式串长度
        public AcNode fail; // 失败指针

        public AcNode(char data) {
            this.data = data;
        }
    }

    /**
     * 将某个敏感词加入 Trie 树
     *
     * @param text
     */
    public void buildTrie(char[] text) {
        AcNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                AcNode newNode = new AcNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        // 表示该字符为字符串结束字符
        p.isEndingChar = true;
    }

    /**
     * 构建失败指针
     */
    public void buildFailurePointer() {
        Queue<AcNode> queue = new LinkedList<>();
        root.fail = null;
        queue.add(root);
        while (!queue.isEmpty()) {
            AcNode p = queue.remove();
            for (int i = 0; i < 26; ++i) {
                AcNode pc = p.children[i];
                if (pc == null) {
                    continue;
                }
                if (p == root) {
                    pc.fail = root;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    /**
     * 在 ac 自动机上匹配主串
     *
     * @param text 主串
     */
    public void match(char[] text) { // text是主串
        int n = text.length;
        AcNode p = root;
        for (int i = 0; i < n; ++i) {
            int idx = text[i] - 'a';
            while (p.children[idx] == null && p != root) {
                p = p.fail; // 失败指针发挥作用的地方
            }
            p = p.children[idx];
            if (p == null) {
                p = root; // 如果没有匹配的，从root开始重新匹配
            }
            AcNode tmp = p;
            while (tmp != root) { // 打印出可以匹配的模式串
                if (tmp.isEndingChar == true) {
                    int pos = i - tmp.length + 1;
                    System.out.println("匹配起始下标" + pos + "; 长度" + tmp.length);
                }
                tmp = tmp.fail;
            }
        }
    }
}
