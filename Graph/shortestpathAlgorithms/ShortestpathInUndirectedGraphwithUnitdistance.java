package shortestpathAlgorithms;

import java.util.*;

public class ShortestpathInUndirectedGraphwithUnitdistance {

    public static void main(String[] args) {
        int n = 9, m = 10;
        int[][] edge = {
                { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 },
                { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 }, { 6, 8 }
        };

        int[] res = shortestPath(edge, n, m, 0);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Create an array of ArrayLists for storing the undirected graph.
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        // Distance array initialized with a large value.
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        // BFS traversal
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : graph[node]) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        // Replace unreachable node distances with -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
