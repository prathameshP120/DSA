import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

    public static void CreateAGraph(ArrayList<Edge>[] graph) {
        int V = 5;
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0-vertex

        graph[0].add(new Edge(0, 1, 5));

        // 1-Vertex

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2-vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // Vertex-3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // Vertex-4
        graph[4].add(new Edge(4, 2, 2));

        for (int i = 0; i < graph[2].size(); i++) {

            Edge e = graph[2].get(i); // src,dest,wt

            // System.out.println(e.dest);

        }

    }

    public static void bfs(ArrayList<Edge>[] graph) {

        //for storing the curr traversing element that we want to print as bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean vis[] = new boolean[graph.length];
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                // add the curr neighbour
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
        }

    }

    public static void main(String[] args) {

        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        CreateAGraph(graph);
        bfs(graph);

    }

}
