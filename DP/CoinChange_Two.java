
// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
// You may assume that you have an infinite number of each kind of coin.
// The answer is guaranteed to fit into a signed 32-bit integer.

/*Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
*/

///it is based on inclusion and exclusion
public class CoinChange_Two {
    public int solveUsingRecursion(int amount, int[] coins, int index) { // index=-1
        // Base cases
        if (amount == 0)
            return 1; // Found a valid way to make the amount
        if (amount < 0 || index >= coins.length)
            return 0; // Invalid path or no more coins to use

        // Recursive cases
        // Option 1: Include the current coin (reduce the amount by the coin's value,
        // stay on the same coin)
        int include = solveUsingRecursion(amount - coins[index], coins, index);

        // Option 2: Exclude the current coin (move to the next coin)
        int exclude = solveUsingRecursion(amount, coins, index + 1);

        // Total ways by including or excluding the current coin
        return include + exclude;
    }

    public int solveUsingTabulation(int amount, int[] coins) {
        // amount = 5, coins = [1,2,5] output=4

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
/*
 * 
 * Let’s dry run the code step by step for amount = 5 and coins = [1, 2, 5].
 * 
 * Initial Setup
 * We initialize:
 * 
 * dp = [0, 0, 0, 0, 0, 0] (size amount + 1)
 * dp[0] = 1 → dp = [1, 0, 0, 0, 0, 0]
 * The goal is to fill the dp array such that dp[j] represents the number of
 * ways to make amount j using the given coins.
 * 
 * Outer Loop (for each coin in coins)
 * Coin = 1
 * We iterate over j from coin to amount (i.e., from 1 to 5):
 * 
 * j = 1
 * dp[1] += dp[1 - 1] → dp[1] += dp[0] → dp[1] = 1
 * Updated dp = [1, 1, 0, 0, 0, 0]
 * 
 * j = 2
 * dp[2] += dp[2 - 1] → dp[2] += dp[1] → dp[2] = 1
 * Updated dp = [1, 1, 1, 0, 0, 0]
 * 
 * j = 3
 * dp[3] += dp[3 - 1] → dp[3] += dp[2] → dp[3] = 1
 * Updated dp = [1, 1, 1, 1, 0, 0]
 * 
 * j = 4
 * dp[4] += dp[4 - 1] → dp[4] += dp[3] → dp[4] = 1
 * Updated dp = [1, 1, 1, 1, 1, 0]
 * 
 * j = 5
 * dp[5] += dp[5 - 1] → dp[5] += dp[4] → dp[5] = 1
 * Updated dp = [1, 1, 1, 1, 1, 1]
 * 
 * Coin = 2
 * We iterate over j from coin to amount (i.e., from 2 to 5):
 * 
 * j = 2
 * dp[2] += dp[2 - 2] → dp[2] += dp[0] → dp[2] = 2
 * Updated dp = [1, 1, 2, 1, 1, 1]
 * 
 * j = 3
 * dp[3] += dp[3 - 2] → dp[3] += dp[1] → dp[3] = 2
 * Updated dp = [1, 1, 2, 2, 1, 1]
 * 
 * j = 4
 * dp[4] += dp[4 - 2] → dp[4] += dp[2] → dp[4] = 3
 * Updated dp = [1, 1, 2, 2, 3, 1]
 * 
 * j = 5
 * dp[5] += dp[5 - 2] → dp[5] += dp[3] → dp[5] = 3
 * Updated dp = [1, 1, 2, 2, 3, 3]
 * 
 * Coin = 5
 * We iterate over j from coin to amount (i.e., from 5 to 5):
 * 
 * j = 5
 * dp[5] += dp[5 - 5] → dp[5] += dp[0] → dp[5] = 4
 * Updated dp = [1, 1, 2, 2, 3, 4]
 * Final Result
 * The value of dp[amount] = dp[5] = 4.
 * This means there are 4 ways to make the amount 5 using coins [1, 2, 5].
 * 
 * Visualization
 * Each step of dp is updated as follows:
 * 
 * yaml
 * Copy
 * Edit
 * Initial: [1, 0, 0, 0, 0, 0]
 * After 1: [1, 1, 1, 1, 1, 1]
 * After 2: [1, 1, 2, 2, 3, 3]
 * After 5: [1, 1, 2, 2, 3, 4]
 * Explanation of the 4 ways
 * 1 + 1 + 1 + 1 + 1
 * 1 + 1 + 1 + 2
 * 1 + 2 + 2
 * 5
 * 
 * 
 */