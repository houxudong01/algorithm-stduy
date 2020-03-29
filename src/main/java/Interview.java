import study.graph.Dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 某公司的笔试题
 *
 * @author:hxd
 * @date:2020/3/27
 */
public class Interview {
    public static void main(String[] args) {
        String word = "apple";
        //System.out.println(valid(word, ""));

        int[][] edges = new int[][]{{1, 2, 1}, {2, 3, 3}, {1, 3, 100}, {1, 4, 1}, {3, 4, 1}};
        System.out.println(minPath(4, edges, 1, 3));
    }

    /**
     * 3. 最⼩小惩罚
     * 给定⼀一个 ⽆无向图 包含 N 个节点和 M 条边, 每条边 Mi 的代价为 Ci 。图中⼀一条 路路径的惩罚是指对该路路径上所有边的代价 Ci 执⾏行行位运算或(bitwise OR)操 作得到的。假如⼀一条路路径上包含了了边 M1，M2，M3 ... ... ，Mk，那么对应的惩 罚就是 C1 OR C2 OR C3 OR ... OR Ck。(OR代表位运算或，即 “|” )
     * 问题:给定图上两个节点 start 和 end，找到从 start 到 end 的所有路路径中惩罚 值最⼩小的路路径，对应的最⼩小惩罚值作为结果返回。如果路路径不不存在就返回 -1。
     * 注意:任意两个节点之间最多存在⼀一条边，图中可能存在有环路路。
     * 参数含义:
     * n:节点总数;节点编号从 1 开始，⼀一直到 n，共有 n 个; edges:⽆无向图的边;edges[i] 表示边Mi，其中 edges[i][0] 和 edges[i][1] 是Mi的两个节点的编号，edges[i][2] 是Mi对应的代价 Ci; start 和 end:路路径的开始和结束节点编号
     * 限制条件: 1 <= n <=1000
     * 1 <= edges.length <= 10000
     * 1 <= Ci <=1024
     *
     * @param n
     * @param edges
     * @param start
     * @param end
     * @return
     */
    static int minPath(int n, int[][] edges, int start, int end) {
        // 构建邻接表
        LinkedList<Edge>[] adj = new LinkedList[n];
        for (int[] e : edges) {
            // 这条边的两个顶点 v1 和 v2，为了节省空间，将所有边的顶点编号都减1存储于对应的矩阵位置上，从0位置开始
            int v1 = e[0] - 1;
            int v2 = e[1] - 1;
            if (adj[v1] == null) {
                adj[v1] = new LinkedList<>();
            }
            adj[v1].add(new Edge(v1, v2, e[2]));
            if (adj[v2] == null) {
                adj[v2] = new LinkedList<>();
            }
            adj[v2].add(new Edge(v2, v1, e[2]));
        }
        // 顶点编号全部减1，从0位置开始
        start = start - 1;
        end = end - 1;

        // 优先级队列，路径或运算值越小越优先
        PriorityQueue queue = new PriorityQueue(n);
        // 记录下标顶点是否已经访问过
        boolean[] inQueue = new boolean[n];
        // 初始化顶点
        Vertex[] vertexes = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        vertexes[start].orValue = 0;
        queue.add(vertexes[start]);
        inQueue[start] = true;

        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll();
            // 已经找到结束顶点
            if (minVertex.id == end) {
                return minVertex.orValue;
            }
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                // 取出当前顶点的一条边
                Edge e = adj[minVertex.id].get(i);
                // 取出这条边的另一个顶点
                Vertex nextVertex = vertexes[e.endId];
                // 计算或运算，用这条边的权重 与 前面经过的所有路径计算出来的或运算值 继续 进行或运算
                int orValue = minVertex.orValue | e.weight;
                // 记录最小的或运算值
                if (orValue < nextVertex.orValue) {
                    nextVertex.orValue = orValue;
                    if (inQueue[nextVertex.id]) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inQueue[nextVertex.id] = true;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 优先级队列， orValue越小优先
     */
    static class PriorityQueue {
        private Vertex[] data;
        private int capacity;
        private int count;

        PriorityQueue(int capacity) {
            this.capacity = capacity;
            data = new Vertex[capacity];
        }

        /**
         * 入队
         *
         * @param vertex
         */
        public void add(Vertex vertex) {
            if (count >= capacity) {
                return;
            }
            data[count] = vertex;
            int i = count;
            // 从下往上堆化
            while ((i - 1) / 2 >= 0 && data[(i - 1) / 2].orValue > data[i].orValue) {
                swap(data, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
            count++;
        }

        /**
         * 出队
         *
         * @return
         */
        public Vertex poll() {
            if (count == 0) {
                return null;
            }
            Vertex minDistVertex = data[0];
            data[0] = data[--count];
            heapIfy(data, count - 1, 0);
            return minDistVertex;
        }

        /**
         * 更新队内节点的值
         *
         * @param vertex
         */
        public void update(Vertex vertex) {
            if (isEmpty()) {
                return;
            }
            int k = 0;
            // 定位到节点，将其 orValue 值更新
            for (int i = 0; i < count; i++) {
                if (data[i].id == vertex.id) {
                    data[i].orValue = vertex.orValue;
                    k = i;
                }
            }

            // 只有 orValue 变小的情况才会更新，所以从节点下标处从下往上堆化
            while ((k - 1) / 2 >= 0 && data[(k - 1) / 2].orValue > data[k].orValue) {
                swap(data, k, (k - 1) / 2);
                k = (k - 1) / 2;
            }
        }

        /**
         * 判断队列是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return count == 0;
        }

        private void swap(Vertex[] data, int i, int j) {
            Vertex temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }


        /**
         * 调整数据让其变成小顶堆
         *
         * @param data
         * @param n
         * @param i
         */
        private void heapIfy(Vertex[] data, int n, int i) {
            while (true) {
                int minPos = i;
                if (2 * i + 1 <= n) {
                    if (data[i] != null
                            && data[2 * i + 1] != null
                            && data[2 * i + 1].orValue < data[i].orValue) {
                        minPos = 2 * i + 1;
                    }
                }
                if (2 * i + 2 <= n) {
                    if (data[minPos] != null
                            && data[2 * i + 2] != null
                            && data[2 * i + 2].orValue < data[minPos].orValue) {
                        minPos = 2 * i + 2;
                    }
                }
                if (minPos == i) {
                    return;
                }
                swap(data, i, minPos);
                i = minPos;
            }
        }
    }

    // 边
    private static class Edge {
        /**
         * 起始顶点
         */
        public int startId;
        /**
         * 结束顶点
         */
        public int endId;
        /**
         * 边的权重
         */
        public int weight;

        public Edge(int startId, int endId, int weight) {
            this.startId = startId;
            this.endId = endId;
            this.weight = weight;
        }
    }

    // 顶点
    private static class Vertex {
        /**
         * 顶点id
         */
        public int id;
        /**
         * 从起始顶点到该顶点计算的 或运算 的值
         */
        public int orValue;

        public Vertex(int id, int orValue) {
            this.id = id;
            this.orValue = orValue;
        }
    }


    /**
     * 2. 缩写校验(建议时间复杂度 O(n) )
     * 给定⼀一个⾮非空字符串串 s 和⼀一个缩写 abbr，请校验它们是否匹配。
     * 假设字符串串中只包含⼩小写字⺟母，缩写中只包含⼩小写字⺟母和数字。缩写中的数字
     * 表示其缩略略的字符数;连续多位数字表示⼀一个多位数。
     * 例例如，字符串串 “word” 的缩写有且仅有以下这些:[“word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", “4"]。
     * 例例 1:输⼊入:s = “internationalization"，abbr = "i12iz4n" 返回:true
     * 解释:abbr 中的 12 表示有⼗⼆个字符被缩略略了了。 例例 2:输⼊入:s = “apple"，abbr = “a2e"
     * 返回:false
     *
     * @param word
     * @param abbr
     * @return
     */
    static boolean valid(String word, String abbr) {
        if (abbr == null || abbr.equals("")) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = abbr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (word.length() == 0) {
                return false;
            }
            // 如果这个字符是数字
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    Integer num = Integer.valueOf(sb.toString());
                    if (num > word.length()) {
                        return false;
                    }
                    word = word.substring(num);
                    // 清空 sb 对象
                    sb.delete(0, sb.length());
                }
                if (word.length() == 0 || c != word.toCharArray()[0]) {
                    return false;
                }
                word = word.substring(1);
            }
        }
        if (sb.length() > 0) {
            Integer num = Integer.valueOf(sb.toString());
            if (num != word.length()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1. 合并时间区间(建议时间复杂度 O(n) )
     * 给定⼀一个按开始时间从⼩小到⼤大排序的时间区间集合，请将重叠的区间合并。时 间区间集合⽤用⼀一个⼆二维数组表示，⼆二维数组的每⼀一⾏行行表示⼀一个时间区间(闭区 间)，其中 0 位置元素表示时间区间开始，1 位置元素表示时间区间结束。
     * 例例 1:输⼊入:[ [1, 3], [2, 6], [8, 10], [15, 18] ]
     * 返回: [ [1, 6], [8, 10], [15, 18]]
     * 解释:时间区间 [1, 3] 和 [2, 6] 有部分重叠，合并之后为 [1, 6]
     * 例例 2:输⼊入:[[1, 4], [4, 5]] 返回:[[1, 5]]
     * 解释:时间区间[1，4] 和 [4，5]重叠了了⼀一个时间点，合并之后为 [1，5]
     *
     * @param intervals
     * @return
     */
    static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        List<int[]> res = new ArrayList<>();
        int m = intervals.length;
        for (int i = 0; i < m; i++) {
            if (i == m - 1) {
                res.add(intervals[i]);
                break;
            }
            // 当前区间的结束端点大于等于下一个区间的结束端点，合并区间
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            }
            // 否则无法合并，存入结果集
            else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[][]{});
    }
}
