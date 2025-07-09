import java.util.ArrayList;

public class DFS {
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

    public static void CreatGraph(ArrayList<Edge>[] graph) {
        int V = 7; // Number of vertices
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>(); // Initialize each index with a new ArrayList
        }

        // 0-vertex
        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        // 1-Vertex
        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 3, 0));

        // 2-vertex
        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 4, 0));

        // 3-vertex
        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));

        // 4-vertex
        graph[4].add(new Edge(4, 2, 0));
        graph[4].add(new Edge(4, 3, 0));
        graph[4].add(new Edge(4, 5, 0));

        // 5-vertex
        graph[5].add(new Edge(5, 3, 0));
        graph[5].add(new Edge(5, 4, 0));
        graph[5].add(new Edge(5, 6, 0));

        // 6-vertex
        graph[6].add(new Edge(6, 5, 0));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        System.out.println(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7; // Updated number of vertices to 7
        ArrayList<Edge> graph[] = new ArrayList[V]; // Declare graph with 7 vertices

        // Initialize the graph array with ArrayLists for each vertex
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>(); // Initialize each index with an ArrayList
        }

        boolean vis[] = new boolean[V]; // Size of visited array also matches V

        CreatGraph(graph);
        dfs(graph, 0, vis);
    }
}
