/*
 * Given an array arr of positive integers, consider all binary trees such that:
Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.

A node is a leaf if and only if it has zero children.
 */

import java.util.*;

public class Minimum_cost_tree_from_leaf_values {
    public static int solveUsingRecursion(List<Integer> arr, Map<Pair<Integer, Integer>, Integer> maxi, int s, int e) {
        // Base case
        if (s > e) {
            return 0;
        }
        if (s == e) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            // i is used here for partitioning
            ans = Math.min(ans, (maxi.get(new Pair<>(s, i)) * maxi.get(new Pair<>(i + 1,
                    e))) +
                    solveUsingRecursion(arr, maxi, s, i) +
                    solveUsingRecursion(arr, maxi, i + 1, e));
        }
        return ans;
    }

    public int solveUsingMem(List<Integer> arr, Map<Pair<Integer, Integer>, Integer> maxi, int s, int e, int[][] dp) {
        // Base case
        if (s > e) {
            return 0;
        }
        if (s == e) {
            return 0;
        }
        if (dp[s][e] != -1) {
            return dp[s][e];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            // i is used here for partitioning
            ans = Math.min(ans, (maxi.get(new Pair<>(s, i)) * maxi.get(new Pair<>(i + 1, e))) +
                    solveUsingMem(arr, maxi, s, i, dp) +
                    solveUsingMem(arr, maxi, i + 1, e, dp));
        }
        dp[s][e] = ans;
        return dp[s][e]; // TC=O(n^3) and SC=(n^2)
    }

    public int solveUsingTabulation(List<Integer> arr, Map<Pair<Integer, Integer>, Integer> maxi) {
        int n = arr.size();
        int[][] dp = new int[n + 2][n + 1]; // i=s_index and dp[i + 1][e_index] here we try to access n+1 index that why
                                            // we have to make n+2 size row

        for (int s_index = n; s_index >= 0; s_index--) {
            for (int e_index = 0; e_index <= n - 1; e_index++) {
                if (s_index >= e_index) {
                    continue;
                }
                int ans = Integer.MAX_VALUE;
                for (int i = s_index; i < e_index; i++) {
                    // i is used here for partitioning
                    ans = Math.min(ans, (maxi.get(new Pair<>(s_index, i)) * maxi.get(new Pair<>(i + 1, e_index))) +
                            dp[s_index][i] + dp[i + 1][e_index]);
                }
                dp[s_index][e_index] = ans;
            }
        }

        return dp[0][n - 1];
    }

    public static int mctFromLeafValues(int[] arr) {
        // Pre-computation
        Map<Pair<Integer, Integer>, Integer> maxi = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            maxi.put(new Pair<>(i, i), arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                maxi.put(new Pair<>(i, j), Math.max(arr[j], maxi.get(new Pair<>(i, j - 1))));
            }
        }

        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveUsingTabulation(Arrays.asList(arr), maxi);

    }

    // Helper class for pairs, since Java doesn't have a built-in pair class
    static class Pair<K, V> {
        public K first;
        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
