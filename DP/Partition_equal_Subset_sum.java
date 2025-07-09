
//it is based on pattern coin change
import java.util.*;

public class Partition_equal_Subset_sum {
    public static boolean solveUsingRecursion(int nums[], int index, int sum, int target) {
        // base case
        if (sum == target) {
            return true;
        }
        if (index >= nums.length || sum > target) {
            return false;
        }
        // recursion
        boolean include = solveUsingRecursion(nums, index + 1, sum + nums[index], target);
        boolean exclude = solveUsingRecursion(nums, index + 1, sum, target);

        return include || exclude;
    }

    public static boolean solveUsingMem(int nums[], int index, int sum, int target, boolean dp[][]) {
        // base case
        if (sum == target) {
            return true;
        }
        if (index >= nums.length || sum > target) {
            return false;
        }
        // recursion
        boolean include = solveUsingMem(nums, index + 1, sum + nums[index], target, dp);
        boolean exclude = solveUsingMem(nums, index + 1, sum, target, dp);

        return dp[index][sum] = (include || exclude);
    }

    public static boolean solveUsingTabulation(int nums[]) {
        int totalSum = 0;

        // Calculate sum of array.
        for (int num : nums) {
            totalSum += num;
        }

        // If total sum is odd, it cannot be partitioned into equal sum subsets.
        if (totalSum % 2 != 0) {
            return false;
        }

        // Calculate the subset sum.
        int target = totalSum / 2;

        // Create a lookup table and fill all entries with FALSE.
        boolean[][] dp = new boolean[target + 1][nums.length + 1];

        // Initialize the first row as TRUE as each array has a subset whose sum is zero
        for (int i = 0; i <= nums.length; i++) {
            dp[0][i] = true;
        }

        // Fill the lookup table in a bottom-up manner.
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if (nums[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - nums[j - 1]][j - 1] || dp[i][j - 1];
                }
            }
        }

        // Return the last index of the matrix, which is our answer.
        return dp[target][nums.length];
    }

    public static boolean canPartition(int nums[]) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        if (totalSum % 2 != 0) {
            // Odd total cannot be partitioned equally
            return false;
        }
        int target = totalSum / 2;
        int currSum = 0;
        int index = 0;
        // return solveUsingRecursion(nums, index,currSum, target);
        // solveUsingMem
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        return solveUsingMem(nums, index, currSum, target, dp);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 5, 11, 5 };
        boolean ans = canPartition(nums);
        System.out.println(ans); // This should now print "true"
    }
}
