package graph;

/**
 * 邻接矩阵实现有向无权图
 *
 * @author:hxd
 * @date:2019/11/11
 */
public class DirectedGraphWithAdjacencyMatrix {
    private int[] vertices;
    private int[][] matrix;

    public DirectedGraphWithAdjacencyMatrix(int verticeSize) {
        this.vertices = new int[verticeSize];
        this.matrix = new int[verticeSize][verticeSize];

        for (int i = 0; i < verticeSize; i++) {
            vertices[i] = i;
        }
    }

    /**
     * 建立顶点 i 和 j 的关系边
     *
     * @param i
     * @param j
     */
    public void addEdge(int i, int j) {
        if (i > vertices.length - 1 || j > vertices.length - 1) {
            return;
        }
        if (i == j) {
            return;
        }
        matrix[i][j] = 1;
    }

    /**
     * 获取顶点 v 的出度
     *
     * @param v
     * @return
     */
    public int getOutDegree(int v) {
        int count = 0;
        for (int i = 0; i < matrix[v].length; i++) {
            if (matrix[v][i] != 0) {
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
        for (int i = 0; i < matrix[v].length; i++) {
            if (matrix[i][v] != 0) {
                count++;
            }
        }
        return count;
    }
}
