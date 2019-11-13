package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接矩阵实现无向无权图
 *
 * @author:hxd
 * @date:2019/11/11
 */
public class UnDirectedGraphWithAdjacencyMatrix {
    private boolean found = false;
    private int[][] adj;
    private int v;


    public UnDirectedGraphWithAdjacencyMatrix(int v) {
        this.v = v;
        this.adj = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                adj[i][j] = -1;
            }
        }
    }

    public void addEdge(int i, int j) {
        if (i >= v || j >= v) {
            return;
        }

        adj[i][j] = 1;
        adj[j][i] = 1;
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
            for (int succeed = 0; succeed < adj[current].length; succeed++) {
                int flag = adj[current][succeed];
                if (flag == 1 && !visited[succeed]) {
                    pre[succeed] = current;
                    if (succeed == target) {
                        print(pre, start, target);
                        return;
                    }
                    visited[succeed] = true;
                    queue.add(succeed);
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
