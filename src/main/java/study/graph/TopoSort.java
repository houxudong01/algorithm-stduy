package study.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序
 * <p>
 * 应用：
 * 可以通过局部顺序推导出全局顺序，比如依赖关系推导
 * 例如：
 * 局部顺序：
 * B->A,C->B,B->D （A依赖B，B依赖C，D依赖B）
 * 可能的全局顺序：
 * C->B->D-A
 * C->B->A->D
 * <p>
 * 注意：
 * 邻接表：s->t，表示 s 先于 t 执行，即 t 依赖 s
 * 逆邻接表：s->t，表示 t 先于 s 执行，即 s 依赖 t
 *
 * @author:hxd
 * @date:2019/11/15
 */
public class TopoSort {
    /**
     * 邻接表，用来存储依赖关系图，有向图
     * adj[0] = 1,2,3，表示顶点 0 先于 顶点 1，2，3执行，即 1，2，3 依赖 0
     */
    private LinkedList<Integer>[] adj;
    /**
     * 顶点个数
     */
    private int v;

    public TopoSort(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 在两个顶点之间新建一条边
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    /**
     * kahn 算法实现
     */
    public void topoSortByKahn() {
        // 统计每个顶点的入度
        int[] inDegree = new int[this.v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                Integer w = adj[i].get(j);
                inDegree[w]++;
            }
        }

        // 存放入度为 0 的顶点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < this.v; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            System.out.print("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                Integer w = adj[i].get(j);
                inDegree[w]--;
                if (inDegree[w] == 0) {
                    queue.add(w);
                }
            }
        }
    }

    /**
     * 利用深度优先遍历算法
     */
    public void topoSortByDfs() {
        // 创建逆邻接表
        LinkedList<Integer>[] inverseAdj = new LinkedList[this.v];
        for (int i = 0; i < this.v; i++) {
            inverseAdj[i] = new LinkedList<>();
        }

        // 通过邻接表创建逆邻接表，
        // 逆邻接表中 s->t，表示 s 依赖 t，t 先于 s执行
        for (int i = 0; i < this.v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                Integer w = adj[i].get(j);
                inverseAdj[w].add(i);
            }
        }

        boolean[] visited = new boolean[this.v];
        for (int i = 0; i < this.v; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            Integer w = inverseAdj[vertex].get(i);
            if (visited[w]) {
                continue;
            }
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        }
        // 先把vertex这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print("->" + vertex);
    }

}
