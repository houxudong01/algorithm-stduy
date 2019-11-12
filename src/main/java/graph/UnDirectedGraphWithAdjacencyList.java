package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表实现无向无权图
 * 实现广度优先搜索
 *
 * @author:hxd
 * @date:2019/11/11
 */
public class UnDirectedGraphWithAdjacencyList {
    // 深度优先搜索要用到
    private boolean found = false;
    private int v;
    private LinkedList<Integer> adj[];

    public UnDirectedGraphWithAdjacencyList(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 无向图广度优先搜索
     *
     * @param start
     * @param target
     */
    public void bfs(int start, int target) {
        // 记录已经被访问过的顶点
        boolean[] visited = new boolean[v];
        visited[start] = true;
        // 记录搜索路径，比如：pre[3] = 2 说明通过顶点 2 的邻接表访问到顶点 3
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        // 用来记录被访问顶点未被访问的相邻节点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (int i = 0; i < adj[current].size(); i++) {
                Integer succeed = adj[current].get(i);
                if (visited[succeed]) {
                    continue;
                }
                pre[succeed] = current;
                if (start == target) {
                    print(pre, start, target);
                    return;
                }
                visited[succeed] = true;
                queue.add(succeed);
            }
        }
    }

    /**
     * 无向图深度优先搜索
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
        recurDfs(start, target, pre, visited);
        print(pre, start, target);
    }

    private void recurDfs(int current, int target, int[] pre, boolean[] visited) {
        if (found) {
            return;
        }
        visited[current] = true;
        if (current == target) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[current].size(); i++) {
            Integer succeed = adj[current].get(i);
            if (!visited[succeed]) {
                pre[succeed] = current;
                recurDfs(succeed, target, pre, visited);
            }
        }
    }

    /**
     * 打印搜索路径
     *
     * @param pre
     * @param start
     * @param target
     */
    private void print(int[] pre, int start, int target) {
        if (pre[target] != -1 && start != target) {
            print(pre, start, pre[target]);
        }
        System.out.println(target + "->");
    }
}
