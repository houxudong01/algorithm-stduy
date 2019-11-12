package graph;

import java.util.LinkedList;

/**
 * 邻接表实现有向无权图
 *
 * @author:hxd
 * @date:2019/11/11
 */
public class DirectedGraphWithAdjacencyList {
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
}
