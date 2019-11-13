package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接矩阵实现有向无权图
 *
 * @author:hxd
 * @date:2019/11/11
 */
public class DirectedGraphWithAdjacencyMatrix {
    private boolean found = false;
    private int[][] adj;
    private int v;

    public DirectedGraphWithAdjacencyMatrix(int v) {
        this.adj = new int[v][v];
        this.v = v;

        // 初始化邻接矩阵
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                adj[i][j] = -1;
            }
        }

    }

    /**
     * 建立顶点 i 和 j 的关系边
     *
     * @param i
     * @param j
     */
    public void addEdge(int i, int j) {
        if (i >= v || j >= v) {
            return;
        }
        adj[i][j] = 1;
    }

    /**
     * 获取顶点 v 的出度
     *
     * @param v
     * @return
     */
    public int getOutDegree(int v) {
        int count = 0;
        for (int i = 0; i < adj[v].length; i++) {
            if (adj[v][i] != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 获取顶点 v 的入度
     *
     * @param v
     * @return
     */
    public int getInDegree(int v) {
        int count = 0;
        for (int i = 0; i < adj[v].length; i++) {
            if (adj[i][v] != 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * 广度优先搜索
     *
     * @param start
     * @param target
     */
    public void bfs(int start, int target) {
        boolean[] visited = new boolean[v];
        visited[start] = true;
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (int j = 0; j < adj[current].length; j++) {
                int flag = adj[current][j];
                if (flag != -1 && !visited[j]) {
                    pre[j] = current;
                    if (j == target) {
                        print(pre, start, target);
                        return;
                    }
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }

    /**
     * 深度优先搜索
     *
     * @param start
     * @param target
     */
    public void dfs(int start, int target) {
        boolean[] visited = new boolean[v];
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        recurseDfs(start, target, pre, visited);
        if (found) {
            print(pre, start, target);
        }
    }

    private void recurseDfs(int current, int target, int[] pre, boolean[] visited) {
        if (found) {
            return;
        }
        visited[current] = true;

        if (current == target) {
            found = true;
            return;
        }

        for (int succeed = 0; succeed < adj[current].length; succeed++) {
            int flag = adj[current][succeed];
            if (flag == 1 && !visited[succeed]) {
                pre[succeed] = current;
                recurseDfs(succeed, target, pre, visited);
            }
        }
    }

    private void print(int[] pre, int start, int target) {
        if (pre[target] != -1 && start != target) {
            print(pre, start, pre[target]);
        }
        System.out.print(target + "->");
    }
}
