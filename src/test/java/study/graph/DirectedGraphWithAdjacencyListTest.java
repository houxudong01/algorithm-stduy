package study.graph;

import org.junit.Test;

/**
 * @author:hxd
 * @date:2019/11/13
 */
public class DirectedGraphWithAdjacencyListTest {

    @Test
    public void search() {
        DirectedGraphWithAdjacencyList graph = new DirectedGraphWithAdjacencyList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);

        System.out.println("bfs:");
        graph.bfs(0,4);
        System.out.println();
        System.out.println("dfs:");
        graph.dfs(0,4);
    }
}
