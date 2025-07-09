/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class NetworkDelayProblem {
    static class Edge {
        int src;
        int dest;
        int time;

        public Edge(int s, int d, int t) {
            this.src = s;
            this.dest = d;
            this.time = t;

        }
    }

    static class Pair {
        int node;
        int time;

        public Pair(int n, int t) {
            this.node = n;
            this.time = t;
        }
    }

    public static int useDijsktra(int Edges[][], int n, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int row[] : Edges) {
            int u = row[0];
            int v = row[1];
            int time = row[2];
            graph[u].add(new Edge(u, v, time));
        }
        int dist[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int u = curr.node;
            for (Edge e : graph[u]) {
                int v = e.dest;
                int time = e.time;
                if (dist[u] + time < dist[v]) {
                    dist[v] = dist[u] + time;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        int Edges[][] = {
                { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 }
        };
        int n = 4;
        int k = 2;
        int ans = useDijsktra(Edges, n, k);
        System.out.println(ans);
    }
}

/*
 * [[2,1,1],[2,3,1],[3,4,1]] n=2 , k=2 => output=2
 * 
 * class Solution {
 * class Edge {
 * int src, dest, time;
 * public Edge(int s, int d, int t) {
 * this.src = s;
 * this.dest = d;
 * this.time = t;
 * }
 * }
 * 
 * class Pair {
 * int node, time;
 * public Pair(int n, int t) {
 * this.node = n;
 * this.time = t;
 * }
 * }
 * 
 * public int networkDelayTime(int[][] times, int n, int k) {
 * ArrayList<Edge>[] graph = new ArrayList[n + 1];
 * for (int i = 0; i <= n; i++) {
 * graph[i] = new ArrayList<>();
 * }
 * for (int[] edge : times) {
 * int u = edge[0], v = edge[1], time = edge[2];
 * graph[u].add(new Edge(u, v, time));
 * }
 * 
 * PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
 * pq.add(new Pair(k, 0));
 * 
 * int[] dist = new int[n + 1];
 * Arrays.fill(dist, Integer.MAX_VALUE);
 * dist[k] = 0;
 * 
 * while (!pq.isEmpty()) {
 * Pair curr = pq.poll();
 * int u = curr.node;
 * for (Edge e : graph[u]) {
 * int v = e.dest, t = e.time;
 * if (dist[u] + t < dist[v]) {
 * dist[v] = dist[u] + t;
 * pq.add(new Pair(v, dist[v]));
 * }
 * }
 * }
 * 
 * int max = 0;
 * for (int i = 1; i <= n; i++) {
 * if (dist[i] == Integer.MAX_VALUE) return -1;
 * max = Math.max(max, dist[i]);
 * }
 * return max;
 * }
 * }
 * 
 */