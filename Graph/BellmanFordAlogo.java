import java.util.ArrayList;

public class BellmanFordAlogo { // O(E*V)
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

    public static void createAgraph(ArrayList<Edge> graph) {
        int V = 5;
        // for (int i = 0; i < graph.length; i++) {
        // graph[i] = new ArrayList<>();
        // }
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));

        graph.add(new Edge(1, 2, -4));

        graph.add(new Edge(2, 3, 2));

        graph.add(new Edge(3, 4, 4));

        graph.add(new Edge(4, 1, -1));

    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
        int dist[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }

        }
        for (int j = 0; j < V - 1; j++) {
            for (int k = 0; k < graph.size(); k++) {
                Edge e = graph.get(k);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    System.out.println(dist[v] + " " + u + "->" + v);
                }
            }
            System.out.println();
            for (int ele : dist) {
                System.out.print(ele + " ");
            }

            System.out.println();

        }
        // Print all src to vertices shortest distances

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");

        }
        System.out.println();
    }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        createAgraph(graph);
        bellmanFord(graph, 0, V);

    }
}
/*
 * The error message
 * "java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5"
 * indicates that your code is trying to access an index of an array that does
 * not exist. In Java, array indices start from 0, so an array of length 5 would
 * have valid indices from 0 to 4.
 * 
 * Here are a few steps you can take to solve this error:
 * 
 * Check array accesses: Review the lines of code near where the error is
 * occurring and ensure that any array accesses are within the bounds of the
 * array. In this case, it seems like you're accessing an array at index 5,
 * which is out of bounds for an array of length 5.
 * 
 * Review loop conditions: If the error is occurring inside a loop, review the
 * loop conditions to ensure they are correct and not causing the loop to access
 * elements beyond the bounds of the array.
 * 
 * Debugging: You can use debugging tools in your IDE (Integrated Development
 * Environment) or print statements to inspect the values of variables and
 * indices at runtime. This can help you identify where the error is occurring
 * and why.
 * 
 * Boundary conditions: Pay special attention to boundary conditions, such as
 * the length of the array and the indices used to access its elements.
 */