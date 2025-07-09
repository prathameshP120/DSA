import java.util.*;

// public class PrintShortestPath {

//     static class Edge {
//         int dest;
//         int wt;

//         public Edge(int dest, int wt) {
//             this.dest = dest;
//             this.wt = wt;
//         }
//     }

//     static class Pair implements Comparable<Pair> {
//         int node;
//         int dist;

//         public Pair(int dist, int node) {
//             this.dist = dist;
//             this.node = node;
//         }

//         @Override
//         public int compareTo(Pair other) {
//             return this.dist - other.dist;
//         }
//     }

//     public static void createGraph(ArrayList<Edge>[] graph, int[][] edges) {
//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         for (int i = 0; i < edges.length; i++) {
//             int u = edges[i][0];
//             int v = edges[i][1];
//             int w = edges[i][2];
//             graph[u].add(new Edge(v, w));
//             graph[v].add(new Edge(u, w)); // undirected
//         }
//     }

//     public static void shortestPath(ArrayList<Edge>[] graph, int V, int src, int dest) {
//         int[] dist = new int[V + 1];
//         int[] parent = new int[V + 1];

//         for (int i = 1; i <= V; i++) {
//             dist[i] = Integer.MAX_VALUE;
//             parent[i] = i;
//         }

//         // PriorityQueue<Pair> pq = new PriorityQueue<>();
//         // dist[src] = 0;
//         // pq.add(new Pair(0, src));

//         // while (!pq.isEmpty()) {
//         // Pair curr = pq.remove();
//         // int u = curr.node;

//         // for (int i = 0; i < graph[u].size(); i++) {
//         // Edge e = graph[u].get(i);
//         // int v = e.dest;
//         // int w = e.wt;

//         // if (dist[v] > dist[u] + w) {
//         // dist[v] = dist[u] + w;
//         // parent[v] = u;
//         // pq.add(new Pair(dist[v], v));
//         // }
//         // }
//         // }
//         PriorityQueue pq = new PriorityQueue<>();
//         pq.add(new Pair(0, src));
//         while (!pq.isEmpty()) {
//             Pair curr = pq.remove();
//             int u = curr.node;
//             for (int i = 0; i < graph[curr.node].size(); i++) {
//                 Edge e = graph[curr.node].get(i);
//                 int v = e.dest;
//                 int wt = e.wt;
//                 if (dist[v] > wt + dist[u]) {
//                     dist[v] = wt + dist[u];
//                     parent[v] = u;
//                     pq.add(new Pair(dist[v], v));

//                 }
//             }

//         }

//         if (dist[dest] == Integer.MAX_VALUE) {
//             System.out.println("-1");
//             return;
//         }

//         ArrayList<Integer> path = new ArrayList<>();
//         int node = dest;
//         while (parent[node] != node) {
//             path.add(node);
//             node = parent[node];
//         }
//         path.add(src);
//         Collections.reverse(path);

//         for (int i = 0; i < path.size(); i++) {
//             System.out.print(path.get(i) + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         int V = 5;
//         int[][] edges = {
//                 { 1, 2, 2 },
//                 { 2, 5, 5 },
//                 { 2, 3, 4 },
//                 { 1, 4, 1 },
//                 { 4, 3, 3 },
//                 { 3, 5, 1 }
//         };

//         @SuppressWarnings("unchecked")
//         ArrayList<Edge>[] graph = new ArrayList[V + 1];
//         createGraph(graph, edges);
//         shortestPath(graph, V, 1, 5);
//     }
// }

import java.util.*;

public class PrintShortestPath {

    static class Edge {
        int dest;
        int wt;

        public Edge(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair {
        int node;
        int dist;

        public Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] edges) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w)); // undirected
        }
    }

    public static void shortestPath(ArrayList<Edge>[] graph, int V, int src, int dest) {
        int[] dist = new int[V + 1];
        int[] parent = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.dist - p2.dist);

        dist[src] = 0;
        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int u = curr.node;

            for (Edge e : graph[u]) {
                int v = e.dest;
                int wt = e.wt;

                if (dist[v] > dist[u] + wt) {
                    dist[v] = dist[u] + wt;
                    parent[v] = u;
                    pq.add(new Pair(dist[v], v));
                }
            }
        }

        if (dist[dest] == Integer.MAX_VALUE) {
            System.out.println("-1");
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int node = dest;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(src);
        Collections.reverse(path);

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                { 1, 2, 2 },
                { 2, 5, 5 },
                { 2, 3, 4 },
                { 1, 4, 1 },
                { 4, 3, 3 },
                { 3, 5, 1 }
        };

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V + 1];
        createGraph(graph, edges);
        shortestPath(graph, V, 1, 5);
    }
}
