//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 题目编号：127
// https://leetcode-cn.com/problems/word-ladder/
@SuppressWarnings("all")
public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            wordList.add(beginWord);
            int m = wordList.size();
            int start = m - 1;
            int end = 0;
            while (end < m && !wordList.get(end).equals(endWord)) {
                end++;
            }
            if (end == m) {
                return 0;
            }
            List<Integer>[] graph = this.buildGraph(wordList);
            return this.getShortestPath(graph, start, end);
        }

        private int getShortestPath(List<Integer>[] graph, int start, int end) {
            Queue<Integer> queue = new LinkedList<>();
            Boolean[] marked = new Boolean[graph.length];
            queue.add(start);
            marked[start] = true;
            int path = 1;
            while (!queue.isEmpty()) {
                path++;
                int size = queue.size();
                while (size-- > 0) {
                    int cur = queue.poll();
                    for (Integer next : graph[cur]) {
                        if (next == end) {
                            return path;
                        }
                        if (Boolean.TRUE.equals(marked[next])) {
                            continue;
                        }
                        queue.add(next);
                        marked[next] = true;
                    }
                }
            }
            return 0;
        }

        private List<Integer>[] buildGraph(List<String> wordList) {
            int m = wordList.size();
            List<Integer>[] graph = new List[m];
            for (int i = 0; i < m; i++) {
                graph[i] = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    if (isConnected(wordList.get(i), wordList.get(j))) {
                        graph[i].add(j);
                    }
                }
            }
            return graph;
        }

        private Boolean isConnected(String s1, String s2) {
            int diffCount = 0;
            for (int i = 0; i < s1.length() && diffCount <= 1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffCount++;
                }
            }
            return diffCount == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}