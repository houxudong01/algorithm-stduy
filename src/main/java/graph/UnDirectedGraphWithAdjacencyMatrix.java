package graph;

/**
 * 邻接矩阵实现无向无权图
 *
 * @author:hxd
 * @date:2019/11/11
 */
public class UnDirectedGraphWithAdjacencyMatrix {
    private int[] vertices;
    private int[][] matrix;

    public UnDirectedGraphWithAdjacencyMatrix(int verticeSize) {
        this.vertices = new int[verticeSize];
        this.matrix = new int[verticeSize][verticeSize];

        for (int i = 0; i < verticeSize; i++) {
            vertices[i] = i;
        }
    }

    public void addEdge(int i, int j) {
        if (i > vertices.length - 1 || j > vertices.length - 1) {
            return;
        }
        if (i == j) {
            return;
        }
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }
}
