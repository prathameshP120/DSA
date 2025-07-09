import java.util.*;

public class DetectCycleUnBFS {
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Node {
        int first, second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static boolean checkForCycle(ArrayList<Edge>[] graph, int s, boolean[] vis) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, -1));
        vis[s] = true;

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for (Edge e : graph[node]) {
                int neighbor = e.dest;

                if (!vis[neighbor]) {
                    q.add(new Node(neighbor, node));
                    vis[neighbor] = true;
                } else if (neighbor != parent) {
                    return true; // Cycle found
                }
            }
        }

        return false; // No cycle
    }

    public static boolean isCycle(ArrayList<Edge>[] graph, int V) {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (checkForCycle(graph, i, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];  //array of arrayList 
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Define edges (same as your CreateAGraph)
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        graph[4].add(new Edge(4, 2, 2));

        boolean hasCycle = isCycle(graph, V);
        System.out.println(hasCycle ? "Cycle Found" : "No Cycle");
    }
}
