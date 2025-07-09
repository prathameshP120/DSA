import java.util.ArrayList;

public class PrintAllPath {
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

    public static void printAllPath(int src, int dest, ArrayList<Edge> graph[], String path) {
        // base case => src=dest
        if (src == dest) {
            System.out.println(path + dest);
            // we to print all possible path
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(e.dest, dest, graph, path + src);
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < 6; i++) {
            graph[i] = new ArrayList<>(); // Initialize each index with a new ArrayList
        }

        // Directed graph without cycle
        graph[5].add(new Edge(5, 0, 0)); //   
        graph[5].add(new Edge(5, 2, 0)); //
        graph[0].add(new Edge(0, 3, 0)); //
        graph[2].add(new Edge(2, 3, 0)); //
        graph[3].add(new Edge(3, 1, 0)); //
        graph[4].add(new Edge(4, 0, 0)); //
        graph[4].add(new Edge(4, 1, 0)); //
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);
        int src = 5;
        int dest = 1;
        printAllPath(src, dest, graph, "");
    }

}
