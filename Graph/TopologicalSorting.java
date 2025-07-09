import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Using DFS:
public class TopologicalSorting {
    public static class Edge {
        int s;
        int d;
        int w;

        public Edge(int src, int dest, int wt) {
            this.s = src;
            this.d = dest;
            this.w = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        int v = graph.length;
        // Initialize adjacency lists for all vertices
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>(); // Initialize each adjacency list as an empty list
        }

        // Add edges (Directed Acyclic Graph)
        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));

        graph[2].add(new Edge(2, 3, 0));
        graph[3].add(new Edge(3, 1, 0));

        graph[4].add(new Edge(4, 1, 0));
        graph[4].add(new Edge(4, 0, 0));
    }

    public static void topoLSort(ArrayList<Edge> graph[]) {
        int v = graph.length;

        boolean vis[] = new boolean[v];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(graph, vis, s, i);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void dfs(ArrayList<Edge> graph[], boolean vis[],
            Stack<Integer> s, int curr) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) { // Iterate over the
            // adjacencylist of the current node
            Edge e = graph[curr].get(i);
            if (!vis[e.d]) {
                dfs(graph, vis, s, e.d);
            }
        }
        s.push(curr);
    }

    public static void calIndegree(ArrayList<Edge> graph[], int inDeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                inDeg[e.d]++;
            }
        }
    }

    public static void topoLSortUsingKhanBFS(ArrayList<Edge> graph[]) {
        int inDeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        calIndegree(graph, inDeg);
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.println(curr);
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.d]--;
                if (inDeg[e.d] == 0) {
                    q.add(e.d);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 6; // Correct number of vertices
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        topoLSortUsingKhanBFS(graph);
    }
}