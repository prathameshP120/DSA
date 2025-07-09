import java.util.*;

public class MstKrushakal {

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

    }

    // Total vertices (update based on your graph)
    static int n = 5; // For graph with vertices 0 to 4
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]); // Path compression
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB)
            return;

        if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else if (rank[parB] < rank[parA]) {
            par[parB] = parA;
        } else {
            par[parB] = parA;
            rank[parA]++;
        }
    }

    public static int kruskalsMST(ArrayList<Edge> edges, int V) {
        edges.sort(Comparator.comparingInt(e -> e.wt));
        init();
        int mstWeight = 0;
        int count = 0;

        for (int i = 0; count < V - 1 && i < edges.size(); i++) {
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA != parB) {
                union(e.src, e.dest);
                mstWeight += e.wt;
                count++;
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();

        // Sample input edges: {src, dest, weight}
        int[][] edgeList = {
                { 0, 1, 2 }, { 0, 2, 1 }, { 1, 2, 1 },
                { 2, 3, 2 }, { 3, 4, 1 }, { 4, 2, 2 }
        };
        for (int[] e : edgeList) {
            edges.add(new Edge(e[0], e[1], e[2]));
        }

        int mstWeight = kruskalsMST(edges, n);
        System.out.println("The sum of all the edge weights: " + mstWeight);
    }
}
