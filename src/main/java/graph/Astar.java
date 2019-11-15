package graph;

import java.util.LinkedList;

/**
 * A* 算法实现
 * A* 是对 Dijkstra 算法的优化和改造
 * 主要优化点：
 * 1.优先级队列构造方式不同，A* 算法是根据f(i)值构建，Dijkstra 算法是根据 dist 构建
 * 2.A* 算法在更新被访问过的顶点 dist 时，会同步更新 f(i) 值
 * 3.循环结束条件不一样。Dijkstra 算法是在重点出队列的时候才结束，A* 算法是一旦遍历到重点就结束
 * <p>
 * 应用：
 * 可以实现游戏中的人物的自动寻路功能，虽然查找到的路径可能不是最短路径，但是却可以避免"跑偏"
 *
 * @author:hxd
 * @date:2019/11/15
 */
public class Astar {
    private LinkedList<Edge>[] adj;
    private int v;
    Vertex[] vertices;

    public Astar(int v) {
        this.v = v;
        vertices = new Vertex[v];
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加顶点的坐标
     *
     * @param id
     * @param x
     * @param y
     */
    public void addVertex(int id, int x, int y) {
        vertices[id] = new Vertex(id, x, y);
    }

    /**
     * 利用 A* 算法实现计算从顶点 start 到 target 的路径
     *
     * @param start
     * @param target
     */
    public void aStar(int start, int target) {
        // 用来还原路径
        int[] predecessor = new int[this.v];
        // 优先级队列，f 越小 越优先
        PriorityQueue queue = new PriorityQueue(this.v);
        // 标记是否进入过队列
        boolean[] inQueue = new boolean[this.v];
        vertices[start].dist = 0;
        vertices[start].f = 0;
        queue.add(vertices[start]);
        inQueue[start] = true;

        while (!queue.isEmpty()) {
            // 堆顶顶点出队
            Vertex minVertex = queue.poll();
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                Edge edge = adj[minVertex.id].get(i);
                Vertex nextVertex = vertices[edge.tid];
                // 当前顶点到起点的距离 加 边的长度 是否小于 下一个顶点距起点的距离
                if (minVertex.dist + edge.w < nextVertex.dist) {
                    // 下一个顶点距起点的距离可以更短
                    nextVertex.dist = minVertex.dist + edge.w;
                    // 估价函数值计算，同时考虑 该顶点距起点的距离 和 该顶点到终点的距离
                    nextVertex.f = nextVertex.dist + getManhattan(nextVertex, vertices[target]);
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inQueue[nextVertex.id]) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inQueue[nextVertex.id] = true;
                    }
                }
                if (nextVertex.id == target) {
                    queue.clear();
                    break;
                }
            }
        }

        // 打印路径
        System.out.print(start);
        print(predecessor, start, target);
    }

    private void print(int[] predecessor, int start, int target) {
        if (start == target) {
            return;
        }
        print(predecessor, start, predecessor[target]);
        System.out.print("->" + target);
    }

    /**
     * 计算两个顶点直接的曼哈顿距离
     *
     * @param v1
     * @param v2
     * @return
     */
    private int getManhattan(Vertex v1, Vertex v2) {
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }

    class Edge {
        /**
         * 边的起始顶点编号
         */
        public int sid;
        /**
         * 边的终止顶点编号
         */
        public int tid;
        /**
         * 权重
         */
        public int w;

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    class Vertex {
        /**
         * 顶点编号ID
         */
        public int id;
        /**
         * 从起始顶点到这个顶点的距离
         */
        public int dist;
        /**
         * 当前顶点在图中的横坐标
         */
        public int x;
        /**
         * 当前顶点在图中的纵坐标
         */
        public int y;
        /**
         * 估价函数：f(i) = g (i) + h(i)
         * g(i):从起点到当前顶点的距离
         * h(i):从当前顶点到重点的 直线 距离
         */
        public int f;

        public Vertex(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.f = Integer.MAX_VALUE;
            this.dist = Integer.MAX_VALUE;
        }
    }

    /**
     * 优先级队列，距离越短越优先
     */
    class PriorityQueue {
        private Vertex[] data;
        private int capacity;
        private int count;

        PriorityQueue(int capacity) {
            this.capacity = capacity;
            data = new Vertex[capacity];
        }

        /**
         * 入队
         *
         * @param vertex
         */
        public void add(Vertex vertex) {
            if (count >= capacity) {
                return;
            }
            data[count] = vertex;
            int i = count;
            // 从下往上堆化
            while ((i - 1) / 2 >= 0 && data[(i - 1) / 2].f > data[i].f) {
                swap(data, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
            count++;
        }

        /**
         * 出队
         *
         * @return
         */
        public Vertex poll() {
            if (count == 0) {
                return null;
            }
            Vertex minDistVertex = data[0];
            data[0] = data[--count];
            heapIfy(data, count - 1, 0);
            return minDistVertex;
        }

        /**
         * 更新队内节点的值
         *
         * @param vertex
         */
        public void update(Vertex vertex) {
            if (isEmpty()) {
                return;
            }
            int k = 0;
            // 定位到节点，将其 dist 值更新
            for (int i = 0; i < count; i++) {
                if (data[i].id == vertex.id) {
                    data[i].dist = vertex.dist;
                    data[i].f = vertex.f;
                    k = i;
                }
            }

            // 只有dist变小的情况才会更新，所以从节点下标处从下往上堆化
            while ((k - 1) / 2 >= 0 && data[(k - 1) / 2].f > data[k].f) {
                swap(data, k, (k - 1) / 2);
                k = (k - 1) / 2;
            }
        }

        /**
         * 清空队列
         */
        public void clear() {
            for (int i = 0; i < count; i++) {
                data[i] = null;
            }
        }

        /**
         * 判断队列是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return count == 0;
        }

        private void swap(Vertex[] data, int i, int j) {
            Vertex temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        private void heapIfy(Vertex[] data, int n, int i) {
            while (true) {
                int minPos = i;
                if (2 * i + 1 <= n) {
                    if (data[i] != null
                            && data[2 * i + 1] != null
                            && data[2 * i + 1].f < data[i].f) {
                        minPos = 2 * i + 1;
                    }
                }
                if (2 * i + 2 <= n) {
                    if (data[minPos] != null
                            && data[2 * i + 2] != null
                            && data[2 * i + 2].f < data[minPos].f) {
                        minPos = 2 * i + 2;
                    }
                }
                if (minPos == i) {
                    return;
                }
                swap(data, i, minPos);
                i = minPos;
            }
        }
    }
}
