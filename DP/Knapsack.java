import java.util.Arrays;

public class Knapsack {

    public static int solveUsingRecursion(int[] wt, int[] profit,
            int index, int capacity) {
        // Base case
        if (index == 0) {
            if (wt[index] <= capacity) {
                return profit[index];
            } else {
                return 0;
            }
        }

        // Include / Exclude
        int nottake = 0 + solveUsingRecursion(wt, profit, index - 1, capacity);
        int take = 0;
        if (wt[index] <= capacity) {
            take = profit[index] + solveUsingRecursion(wt, profit, index - 1, capacity - wt[index]);
        }
        return Math.max(nottake, take);
    }

    public static void printDPArray(int[][] dp) {
        System.out.println("\n\nPrinting DP array:");
        for (int[] row : dp) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        // Base case: If there are no items or the knapsack capacity is zero
        if (ind == 0) {
            if (wt[0] <= W) {
                // Include the item if its weight is within the capacity
                return val[0];
            } else {
                // Otherwise, exclude the item
                return 0;
            }
        }

        // If the result for this subproblem is already calculated, return it
        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        // Calculate the maximum value when the current item is not taken
        int notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp);

        // Calculate the maximum value when the current item is taken
        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            taken = val[ind] + knapsackUtil(wt, val, ind - 1, W - wt[ind], dp);
        }

        // Store and return the result for the current state
        dp[ind][W] = Math.max(notTaken, taken);
        return dp[ind][W];
    }

    // public static int solveUsingTabulation(int capacity, int[] wt, int[] profit,
    // int n) {
    // int[][] dp = new int[capacity + 1][n + 1];

    // for (int[] row : dp) {
    // Arrays.fill(row, -1);
    // }

    // for (int row = 0; row <= capacity; row++) {
    // dp[row][n] = 0;
    // }

    // for (int i = 0; i <= capacity; i++) {
    // for (int j = n - 1; j >= 0; j--) {
    // int include = 0;
    // if (wt[j] <= i) {
    // include = profit[j] + dp[i - wt[j]][j + 1];
    // }
    // int exclude = 0 + dp[i][j + 1];
    // dp[i][j] = Math.max(include, exclude);
    // }
    // }
    // printDPArray(dp);

    // return dp[capacity][0];
    // }
    public static int solveUsingTabulation(int[] wt, int[] profit, int capacity) {
        // Create a 2D DP array to store the maximum value for each subproblem
        int n = wt.length;
        int dp[][] = new int[n][capacity + 1];

        // Base Condition
        for (int i = wt[0]; i <= capacity; i++) {
            dp[0][i] = profit[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= capacity; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = dp[ind - 1][cap];

                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = profit[ind] + dp[ind - 1][cap - wt[ind]];
                }

                // Store the maximum value for the current state
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }
        printDPArray(dp);
        return dp[n - 1][capacity];
    }

    public static int solveUsingTabulationSO2(int[] wt, int[] profit, int capacity) {
        int n = wt.length;
        // Create an array to store the maximum value for each capacity (previous row)
        int prev[] = new int[capacity + 1];

        // Base Condition: Initialize the first row of the array
        for (int i = wt[0]; i <= capacity; i++) {
            prev[i] = profit[0];
        }

        // Iterate through each item and capacity
        for (int ind = 1; ind < n; ind++) {
            for (int cap = capacity; cap >= 0; cap--) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = prev[cap];

                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = profit[ind] + prev[cap - wt[ind]];
                }

                // Update the array with the maximum value for the current capacity
                prev[cap] = Math.max(notTaken, taken);
            }
        }

        // The result is stored in the last element of the array
        return prev[capacity];
    }

    public static void main(String[] args) {
        int capacity = 6;
        int[] wt = { 1, 2, 3 };
        int[] profit = { 10, 15, 40 };
        int n = 3;

        // int ans = solveUsingRecursion(wt, profit, n - 1, capacity);
        // Test the optimized tabulation approach
        int ans = solveUsingTabulation(wt, profit, capacity);

        // space optimization
        // int ans = solveUsingTabulationSO2(wt, profit, capacity);

        System.out.println("Max Profit: " + ans);

    }
}
