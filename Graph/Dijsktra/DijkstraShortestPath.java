package Dijsktra;

// as you include the package you have to run the code like this  
/*
cd "c:\Users\patil\OneDrive\Desktop\DSA-ALL\Graph"
javac Dijsktra\DijkstraShortestPath.java
java Dijsktra.DijkstraShortestPath
 */
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraShortestPath {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;

        }
    }

    static class Pair { // implements Comparable<Pair>
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;

        }

        // @Override
        // public int compareTo(Pair p2) {
        // return this.path - p2.path; // Path based Sorting

        // }
    }

    public static void DijkstraPath(ArrayList<Edge> graph[], int src) {

        // you can also do
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.path - y.path);
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) { // initialize
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;

            }
        } // priorityQueue which is min-heap
        boolean vis[] = new boolean[graph.length];
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int j = 0; j < graph[curr.n].size(); j++) {
                    Edge e = graph[curr.n].get(j);
                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;
                    if (dist[v] > dist[u] + w) {
                        dist[v] = dist[u] + w;
                        pq.add(new Pair(v, dist[v]));
                    }

                }
            }

        }
        // Print all source to vertice shortest Path
        for (int k = 0; k < dist.length; k++) {
            System.out.print(dist[k] + " ");

        }
        System.out.println();

    }

    public static void createAgraph(ArrayList<Edge> graph[]) {
        int V = 6;
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createAgraph(graph);
        DijkstraPath(graph, 0);
    }

}

/*
 * Dijkstra's algorithm is a graph traversal algorithm used to find the shortest
 * path from a source vertex to all other vertices in a weighted graph with
 * non-negative edge weights.
 * 
 * It works by greedily selecting the nearest unvisited node, updating the
 * shortest distances to its neighbors, and repeating this process until the
 * shortest paths to all nodes are determined.
 * It works for both directed and undirected
 */