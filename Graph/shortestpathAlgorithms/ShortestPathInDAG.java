package shortestpathAlgorithms;

import java.util.*;

public class ShortestPathInDAG {
    class Pair {
        int first, second;

        Pair(int _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }

    private void topoSort(int node, ArrayList<Pair>[] graph, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for (Pair p : graph[node]) {
            int v = p.first;
            if (vis[v] == 0) {
                topoSort(v, graph, vis, st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Use array of ArrayList<Pair>
        ArrayList<Pair>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        // Build the graph
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            graph[u].add(new Pair(v, wt));
        }

        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();
        // Perform Topological Sort for all vertices
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, graph, vis, st);
            }
        }

        // Initialize distances with a large value
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = (int) (1e9);
        }
        dist[0] = 0; // Starting node has distance 0

        // Process each node in topologically sorted order
        while (!st.isEmpty()) {
            int node = st.pop();
            for (Pair p : graph[node]) {
                int v = p.first;
                int wt = p.second;
                if (dist[node] != (int) (1e9) && dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }
        // Replace unreachable nodes with -1
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) (1e9)) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    public static void main(String[] args) {

    }
}
