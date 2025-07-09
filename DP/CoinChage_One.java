import java.util.*;

////exploring all possible ways
class CoinChage_One {
    // Recursion
    public static int solveUsingRec(List<Integer> coins, int index, int amount) {
        // Base case
        if (index == 0) {
            if (amount % coins.get(0) == 0) {
                return amount / coins.get(index);
            } else {
                return (int) Math.pow(10, 9);
            }
        }
        int nottake = 0 + solveUsingRec(coins, index - 1, amount);
        int take = (int) Math.pow(10, 9);
        if (coins.get(index) <= amount) {
            take = 1 + solveUsingRec(coins, index, amount - coins.get(index));
        }
        int ans = Math.min(take, nottake);
        return ans;
    }

    // Memoization
    public static int solveUsingMem(List<Integer> coins, int amount, int index, int[][] dp) {
        // Base case
        if (index == 0) {
            if (amount % coins.get(0) == 0) {
                return amount / coins.get(index);
            } else {
                return (int) Math.pow(10, 9);
            }
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }
        int nottake = 0 + solveUsingMem(coins, amount, index - 1, dp);
        int take = (int) Math.pow(10, 9);
        if (coins.get(index) <= amount) {
            take = 1 + solveUsingMem(coins, amount - coins.get(index), index, dp);
        }
        dp[index][amount] = Math.min(take, nottake);
        return dp[index][amount];
    }

    // Tabulation
    public int solveUsingTabulation(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        // there is index=0 and every tim amount changes
        for (int tar = 0; tar <= amount; tar++) {
            if (tar % coins[0] == 0) {
                dp[0][tar] = tar / coins[0];
            } else {
                dp[0][tar] = (int) Math.pow(10, 9);
            }
        }
        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = 0 + dp[ind - 1][target];
                int take = (int) Math.pow(10, 9);

                // If the current element is less than or equal to the target, calculate 'take'
                if (coins[ind] <= target)
                    take = 1 + dp[ind][target - coins[ind]];

                // Store the minimum result in the dp array
                dp[ind][target] = Math.min(notTake, take);
            }
        }

        // Get the minimum number of elements needed for the target sum
        int ans = dp[n - 1][amount];

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 5 };
        // Create an empty ArrayList
        ArrayList<Integer> coinsList = new ArrayList<>();

        // Iterate through the array and add each element to the ArrayList
        for (int coin : coins) {
            coinsList.add(coin);
        }
        int amount = 11;
        // solveUsingMem
        int dp[][] = new int[coinsList.size()][amount + 1];
        for (int r[] : dp) {
            Arrays.fill(r, -1);
        }
        // int ans = solveUsingRec(coinsList, coinsList.size() - 1, amount);
        int ans = solveUsingMem(coinsList, amount, coinsList.size() - 1, dp);
        System.out.println(ans);
    }
}
