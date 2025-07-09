import java.util.Arrays;
import java.util.List;

class HouseRob {

    public int solveUsingRecursion(List<Integer> nums, int index) {
        // Base case
        if (index >= nums.size()) {
            return 0;
        }

        // Recursive relation
        int include = nums.get(index) + solveUsingRecursion(nums, index + 2);
        int exclude = solveUsingRecursion(nums, index + 1);
        return Math.max(include, exclude);
    }

    // Memoization
    public int solveUsingMem(List<Integer> nums, int index, int[] dp) {
        // Base case
        if (index >= nums.size()) {
            return 0;
        }

        // Answer already exists
        if (dp[index] != -1) {
            return dp[index];
        }

        // Recursive relation
        int include = nums.get(index) + solveUsingMem(nums, index + 2, dp);
        int exclude = solveUsingMem(nums, index + 1, dp);
        dp[index] = Math.max(include, exclude);
        return dp[index];
    }

    // Tabulation
    public int solveUsingTabulation(List<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];

        // Step 1: Initialize the dp array
        dp[n - 1] = nums.get(n - 1);

        // Step 2: Fill the dp array
        for (int index = n - 2; index >= 0; index--) {
            int tempAns = 0;
            if (index + 2 < n) {
                tempAns = dp[index + 2];
            }
            int include = nums.get(index) + tempAns;
            int exclude = dp[index + 1];
            dp[index] = Math.max(include, exclude);
        }
        return dp[0];
    }

    // Space Optimization
    public int solveUsingTabulationSO(List<Integer> nums) {
        int n = nums.size();
        int prev = nums.get(n - 1);
        int next = 0;
        int curr = 0;

        for (int index = n - 2; index >= 0; index--) {
            int tempAns = 0;
            if (index + 2 < n) {
                tempAns = next;
            }
            int include = nums.get(index) + tempAns;
            int exclude = prev;
            curr = Math.max(include, exclude);

            // Update variables
            next = prev;
            prev = curr;
        }
        return prev;
    }

    public int rob(List<Integer> nums) {
        int n = nums.size();
        return solveUsingTabulationSO(nums);
    }
}
