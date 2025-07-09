import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class isBipartite {

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

    public static void createGraph(ArrayList<Edge>[] graph) {
        int V = graph.length;
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Graph construction as per the original GFG-style example
        graph[0].add(new Edge(0, 2, 0));
        graph[2].add(new Edge(2, 0, 0));

        graph[0].add(new Edge(0, 3, 0));
        graph[3].add(new Edge(3, 0, 0));

        graph[1].add(new Edge(1, 3, 0));
        graph[3].add(new Edge(3, 1, 0));

        graph[2].add(new Edge(2, 3, 0));
        graph[3].add(new Edge(3, 2, 0));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int V = graph.length;
        int[] color = new int[V];

        // Initialize all colors to -1
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        // Check each component
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!checkBipartite(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkBipartite(ArrayList<Edge>[] graph, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0; // Start coloring with 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                int neighbor = e.dest;

                if (color[neighbor] == -1) {
                    int nextCol = color[curr] == 0 ? 1 : 0;
                    color[e.dest] = nextCol;
                    q.add(e.dest);
                } else if (color[neighbor] == color[curr]) {
                    return false; // Same color on both sides, not bipartite
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean ans = isBipartite(graph);
        System.out.println(ans);
    }
}
