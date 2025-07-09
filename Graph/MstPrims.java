import java.util.ArrayList;
import java.util.PriorityQueue;

public class MstPrims {

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

    static class Pair {
        int node;
        int distance;

        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static int primsUsingGFGLogic(int V, ArrayList<Edge>[] graph) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] vis = new int[V];
        int sum = 0;

        pq.add(new Pair(0, 0)); // Start from node 0

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int node = curr.node;
            int wt = curr.distance;

            if (vis[node] == 1)
                continue;

            vis[node] = 1;
            sum += wt;

            for (Edge e : graph[node]) {
                if (vis[e.dest] == 0) {
                    pq.add(new Pair(e.wt, e.dest));
                }
            }
        }

        return sum;
    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] edges) {
        int V = graph.length;
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w)); // since undirected
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                { 0, 1, 2 },
                { 0, 2, 1 },
                { 1, 2, 1 },
                { 2, 3, 2 },
                { 3, 4, 1 },
                { 4, 2, 2 }
        };

        @SuppressWarnings("unchecked") // this is complusary as you use the array of arraylist
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, edges);

        int totalCost = primsUsingGFGLogic(V, graph);
        System.out.println("The sum of all the edge weights: " + totalCost);
    }
}
