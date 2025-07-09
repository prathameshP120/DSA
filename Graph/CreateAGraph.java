// import java.util.*;

import java.util.ArrayList;

public class CreateAGraph {
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

    public static void main(String[] args) {

        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];

        // graph => An array of ArrayLists
        // graph[i] => A single ArrayList from that array
        // graph[i].get(j) => A single Edge object from that ArrayList

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

            System.out.println(e.dest);

        }

    }

}
/*
 * Edge is a custom class that holds:
 * src → source node
 * 
 * dest → destination node
 * 
 * wt → weight of the edge
 * 
 * 
 * graph --> [ 0 ] --> ArrayList<Edge> --> [Edge(0,1,5)]
 * [ 1 ] --> ArrayList<Edge> --> [Edge(1,0,5), Edge(1,2,1)]
 * [ 2 ] --> ArrayList<Edge> --> [Edge(2,1,1), Edge(2,3,1)]
 * [ 3 ] --> ArrayList<Edge> --> [Edge(3,1,3)]
 * [ 4 ] --> ArrayList<Edge> --> [Edge(4,2,2)]
 * 
 * graph → the whole array (length = 5)
 * graph[2] → the list at index 2
 * graph[2].get(1) → the second edge in the list at index 2 (an Edge object)
 * 
 * ArrayList<Edge> graph[] = new ArrayList[V]; =>
 * You're creating an array of ArrayList<Edge>—meaning:
 * 
 * graph is an array of size V (5 in this case).
 * 
 * Each element of this array is an ArrayList that will store Edge objects.
 * 
 * So, each graph[i] represents the adjacency list for vertex i, storing edges
 * from that vertex to its neighbors.
 */