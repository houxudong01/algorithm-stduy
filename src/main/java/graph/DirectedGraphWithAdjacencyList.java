package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表 实现有向无权图
 *
 * @author:hxd
 * @date:2019/11/11
 */
public class DirectedGraphWithAdjacencyList {
    private boolean found = false;
    private int v;
    private LinkedList<Integer>[] adj;

    public DirectedGraphWithAdjacencyList(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
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
            for (int i = 0; i < adj[current].size(); i++) {
                Integer succeed = adj[current].get(i);
                if (!visited[succeed]) {
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

    public void recurseDfs(int start, int target, int[] pre, boolean[] visited) {
        if (found) {
            return;
        }
        visited[start] = true;
        if (start == target) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[start].size(); i++) {
            Integer succeed = adj[start].get(i);
            if (!visited[succeed]) {
                pre[succeed] = start;
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
