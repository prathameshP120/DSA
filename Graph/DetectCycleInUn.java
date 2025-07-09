import java.util.ArrayList;

public class DetectCycleInUn {
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
        // // 0-vertex
        // graph[0].add(new Edge(0, 1, 0));
        // graph[0].add(new Edge(0, 2, 0));

        // // 1-Vertex
        // graph[1].add(new Edge(1, 0, 0));
        // graph[1].add(new Edge(1, 3, 0));

        // // 2-vertex
        // graph[2].add(new Edge(2, 0, 0));
        // graph[2].add(new Edge(2, 4, 0));

        // // 3-vertex
        // graph[3].add(new Edge(3, 1, 0));
        // graph[3].add(new Edge(3, 4, 0));
        // graph[3].add(new Edge(3, 5, 0));

        // // 4-vertex
        // graph[4].add(new Edge(4, 2, 0));
        // graph[4].add(new Edge(4, 3, 0));
        // graph[4].add(new Edge(4, 5, 0));

        // // 5-vertex
        // graph[5].add(new Edge(5, 3, 0));
        // graph[5].add(new Edge(5, 4, 0));
        // graph[5].add(new Edge(5, 6, 0));

        // // 6-vertex
        // graph[6].add(new Edge(6, 5, 0));

        // The following graph does not contain any cycle
        // 1-vertex

        // Add both directions for undirected edges
        graph[1].add(new Edge(1, 2, 0));
        graph[2].add(new Edge(2, 1, 0)); // Reverse direction

        graph[2].add(new Edge(2, 3, 0));
        graph[3].add(new Edge(3, 2, 0)); // Reverse direction

        graph[2].add(new Edge(2, 4, 0));
        graph[4].add(new Edge(4, 2, 0)); // Reverse direction

        graph[4].add(new Edge(4, 5, 0));
        graph[5].add(new Edge(5, 4, 0)); // Reverse direction

        graph[5].add(new Edge(5, 6, 0));
        graph[6].add(new Edge(6, 5, 0)); // Reverse direction

    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        // for (int i = 0; i < graph.length; i++) {
        // if (!vis[i]) {
        // if (detectCycleUtil(graph, vis, i, -1)) {
        // return true;
        // }
        // }
        // }
        // return false;
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int parent) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case 1 : if neighbour is not visited => simple apply normal dfs

            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr))
                    return true;

                // case 2: neighbour of current is visited and it is also current parrents =>

                // do nothing

                // case 3: if neighbour of curr is visited and it is not parent of current =>
                // then there is cycle is present
                else if (e.dest != parent) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {

        int V = 7; // Updated number of vertices to 7
        ArrayList<Edge>[] graph = new ArrayList[V]; // Declare graph with 7 vertices

        // Initialize the graph array with ArrayLists for each vertex
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>(); // Initialize each index with an ArrayList
        }

        boolean vis[] = new boolean[V]; // Size of visited array also matches V

        CreatGraph(graph);
        boolean ans = detectCycle(graph);  //using dfs
        System.out.println(ans);
    }
}
