package graph;

import java.util.LinkedList;

/**
 * 邻接表实现无向无权图
 *
 * @author:hxd
 * @date:2019/11/11
 */
public class UnDirectedGraphWithAdjacencyList {
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
}
