package study.graph;

import java.util.LinkedList;

/**
 * 实现 Dijkstra 算法，在有向有权图上查找两个顶点的最短路径
 *
 * @author:hxd
 * @date:2019/11/14
 */
public class Dijkstra {
    private LinkedList<Edge>[] adj;
    private int v;

    public Dijkstra(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加一条边
     *
     * @param s 开始顶点编号
     * @param t 结束顶点编号
     * @param w 权重
     */
    public void addEdge(int s, int t, int w) {
        this.adj[s].add(new Edge(s, t, w));
    }

    /**
     * 求顶点 start 到 顶点 target 的最短距离
     *
     * @param start
     * @param target
     */
    public void dijkstra(int start, int target) {
        // 用来记录还原最短路径
        int[] predecessor = new int[this.v];
        // 初始化每个顶点
        Vertex[] vertices = new Vertex[this.v];
        for (int i = 0; i < this.v; i++) {
            vertices[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        // 小顶堆优先级队列
        PriorityQueue queue = new PriorityQueue(this.v);
        // 标记是否进入过优先级队列
        boolean[] inQueue = new boolean[this.v];
        vertices[start].dist = 0;
        // 起始顶点入队
        queue.add(vertices[start]);
        inQueue[start] = true;

        while (!queue.isEmpty()) {
            // 取出距起点距离最短的顶点
            Vertex minVertex = queue.poll();
            if (minVertex.id == target) {
                break;
            }
            // 遍历距起点最短距离顶点的相邻顶点
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                // 取出顶点连接的一条边
                Edge edge = adj[minVertex.id].get(i);
                // 取出该边的另一个顶点
                Vertex nextVertex = vertices[edge.tid];
                // 如果当前节点距起点距离加权重小于下一个节点的距起点距离，那么更新下一个节点的距起点距离
                if (minVertex.dist + edge.w < nextVertex.dist) {
                    nextVertex.dist = minVertex.dist + edge.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inQueue[nextVertex.id]) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inQueue[nextVertex.id] = true;
                    }
                }
            }
        }

        // 打印路径
        System.out.print(start);
        print(start, target, predecessor);
    }

    private void print(int start, int target, int[] predecessor) {
        if (start == target) {
            return;
        }
        print(start, predecessor[target], predecessor);
        System.out.println("->" + target);
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

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
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
            while ((i - 1) / 2 >= 0 && data[(i - 1) / 2].dist > data[i].dist) {
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
                    k = i;
                }
            }

            // 只有dist变小的情况才会更新，所以从节点下标处从下往上堆化
            while ((k - 1) / 2 >= 0 && data[(k - 1) / 2].dist > data[k].dist) {
                swap(data, k, (k - 1) / 2);
                k = (k - 1) / 2;
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
                            && data[2 * i + 1].dist < data[i].dist) {
                        minPos = 2 * i + 1;
                    }
                }
                if (2 * i + 2 <= n) {
                    if (data[minPos] != null
                            && data[2 * i + 2] != null
                            && data[2 * i + 2].dist < data[minPos].dist) {
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

