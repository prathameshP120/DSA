import java.util.ArrayList;

public class DetectCycleInDirectedGrph {

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
            graph[i] = new ArrayList<>();
        }

        // Directed graph without cycle
        graph[1].add(new Edge(1, 2, 0)); // 1 -> 2
        graph[2].add(new Edge(2, 3, 0)); // 2 -> 3
        graph[3].add(new Edge(3, 4, 0)); // 3 -> 4
        graph[3].add(new Edge(3, 5, 0)); // 3 -> 5
        graph[4].add(new Edge(4, 5, 0)); // 4 -> 5
        graph[5].add(new Edge(5, 6, 0)); // 5 -> 6

        // Uncomment to test cycle
        // graph[6].add(new Edge(6, 3, 0)); // 6 -> 3 (cycle: 3 -> 4 -> 5 -> 6 -> 3)
    }

    private static boolean dfsCheck(int node, ArrayList<Edge>[] graph, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (Edge e : graph[node]) {
            int neighbor = e.dest;

            if (vis[neighbor] == 0) {
                if (dfsCheck(neighbor, graph, vis, pathVis)) {
                    return true;
                }
            } else if (pathVis[neighbor] == 1) {
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, graph, vis, pathVis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        CreatGraph(graph);
        boolean ans = detectCycle(graph);
        System.out.println(ans);
    }
}
/*
 * algorithm steps are as follows:
 * We will traverse the graph component-wise using the DFS technique.
 * Make sure to carry two visited arrays in the DFS call. One is a visited
 * array(vis) and the other is a path-visited(pathVis) array. The visited array
 * keeps a track of visited nodes, and the path-visited keeps a track of visited
 * nodes in the current traversal only.
 * While making a DFS call, at first we will mark the node as visited in both
 * the arrays and then will traverse through its adjacent nodes. Now, there may
 * be either of the three cases:
 * Case 1: If the adjacent node is not visited, we will make a new DFS call
 * recursively with that particular node.
 * Case 2: If the adjacent node is visited and also on the same path(i.e marked
 * visited in the pathVis array), we will return true, because it means it has a
 * cycle, thereby the pathVis was true. Returning true will mean the end of the
 * function call, as once we have got a cycle, there is no need to check for
 * further adjacent nodes.
 * Case 3: If the adjacent node is visited but not on the same path(i.e not
 * marked in the pathVis array), we will continue to the next adjacent node, as
 * it would have been marked as visited in some other path, and not on the
 * current one.
 * Finally, if there are no further nodes to visit, we will unmark the current
 * node in the pathVis array and just return false. Then we will backtrack to
 * the previous node with the returned value. The point to remember is, while we
 * enter we mark both the pathVis and vis as true, but at the end of traversal
 * to all adjacent nodes, we just make sure we unmark the pathVis and still keep
 * the vis marked as true, as it will avoid future extra traversal calls.
 */