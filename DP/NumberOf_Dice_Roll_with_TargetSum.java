import java.util.Arrays;

public class NumberOf_Dice_Roll_with_TargetSum {
    public static int solveUsingRecursion(int n, int k, int target) {
        int ans = 0;
        // base case
        if (target == 0 && n == 0) { // means target==0 ans all dice are also used
            return 1;
        }
        if (target != 0 && n == 0) {
            return 0;
        }
        if (target == 0 && n != 0) {
            return 0;
        }
        for (int i = 1; i <= k; i++) { // i is the face value on die
            ans += solveUsingRecursion(n - 1, k, target - i);

        }
        return ans;
    }

    public static int solveUsingMem(int n, int k, int target, int[][] dp) {
        int Mod = 1000000007; // Modulo value to prevent overflow
        // Base cases
        if (target == 0 && n == 0) { // Target achieved and no dice left
            return 1;
        }
        if (target == 0 || n == 0) { // If target is 0 but we still have dice, or vice versa
            return 0;
        }
        // If answer is already present in dp
        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        int ans = 0;
        for (int i = 1; i <= k; i++) { // i represents the face value on die
            if (target - i >= 0) { // Only proceed if target - i is non-negative
                int recAns = solveUsingMem(n - 1, k, target - i, dp) % Mod;
                ans = (ans + recAns) % Mod;
            }
        }
        dp[n][target] = ans; // Memoize the result
        return ans;
    }

    public static int solveUsingTabulation(int n, int k, int target) {
        int Mod = 1000000007;
        int dp[][] = new int[n + 1][target + 1];
        dp[n][target] = 1;
        for (int dice = n - 1; dice >= 0; dice--) {
            for (int sum = target; sum >= 0; sum--) {
                int ans = 0;
                for (int face = 1; face <= k; face++) {
                    int recAns = 0;
                    if ((sum + face) <= target) {
                        recAns = dp[dice + 1][sum + face];

                    }
                    ans = (ans + recAns) % Mod;

                }
                dp[dice][sum] = ans;
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args) {
        int n = 2;
        int k = 6;
        int target = 7;
        // int ans = solveUsingRecursion(n, k, target);
        // System.out.println(ans);

        // solveUsingMem

        int dp[][] = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // int ans = solveUsingMem(n, k, target, dp);
        // System.out.println(ans);

        // Tabulation
        int ans = solveUsingTabulation(n, k, target);
    }
}
