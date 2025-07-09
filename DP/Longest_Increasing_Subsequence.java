import java.util.*;

public class Longest_Increasing_Subsequence {

    public static int solveUsingRec(int nums[], int ind, int prev) {
        // base case

        if (ind == nums.length) {
            return 0;
        }
        int nottake = 0 + solveUsingRec(nums, ind + 1, prev); // not take
        int take = 0;
        if (prev == -1 || nums[ind] > nums[prev]) {
            take = 1 + solveUsingRec(nums, ind + 1, ind); // take
        }

        int len = Math.max(take, nottake);
        return len;
    }

    public static int solveUsingMem(int nums[], int ind, int prev, int dp[][]) {
        // base case

        if (ind == nums.length) {
            return 0;
        }
        // if ans is already exist
        // here we use dp array always make prev+1 , otherwise it will give the
        // error because prev is declare to -1
        // In memoization we do the shifting here prev to prev+1
        if (dp[ind][prev + 1] != -1) {
            return dp[ind][prev + 1];

        }
        int take = 0;
        int nottake = 0 + solveUsingMem(nums, ind + 1, prev, dp);
        if (prev == -1 || nums[ind] > nums[prev]) {
            take = 1 + solveUsingMem(nums, ind + 1, ind, dp);
        }

        dp[ind][prev + 1] = Math.max(take, nottake);
        return dp[ind][prev + 1];
    }

    public static int solveUsingTabulation(int nums[]) {
        int n = nums.length;
        // there is no need to handle the base case because the dp array is
        // automatically declare as 0

        int dp[][] = new int[n + 1][n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev_idx = ind - 1; prev_idx >= -1; prev_idx--) {

                int nottake = 0 + dp[ind + 1][prev_idx + 1]; // dp[ind] indicates the next row
                int take = 0;
                if (prev_idx == -1 || nums[ind] > nums[prev_idx]) {
                    // take = 1 + dp[ind + 1][ind];
                    // first time above line gave me error Because at one time prev_idx becomes 0
                    // so we have to always do the shifting here . so we do the following
                    // modification in the code
                    take = 1 + dp[ind + 1][ind + 1];
                }

                dp[ind][prev_idx + 1] = Math.max(take, nottake); // dp[c_idx] indicates the currrow

            }

        }
        return dp[0][0];
    }

    public int solveUsingTabulationSO(int[] nums) {
        int n = nums.length;

        // Initialize the current and next rows for space optimization
        int[] currRow = new int[n + 1];
        int[] prevRow = new int[n + 1];

        // Outer loop for the current index (bottom-up approach)
        for (int index = n - 1; index >= 0; index--) {
            // Inner loop for the previous index
            for (int prev = index - 1; prev >= -1; prev--) {
                int nottake = 0 + prevRow[prev + 1];
                int take = 0;
                // take current element if valid
                if (prev == -1 || nums[index] > nums[prev]) {
                    take = 1 + prevRow[index + 1];
                }
                // nottake current element
                // Store the result in the current row
                currRow[prev + 1] = Math.max(take, nottake);

            }
            // Shift the current row to the next row for the next iteration
            prevRow = currRow.clone();
        }

        return currRow[0];
    }

    public static int optimizeDP(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        // only one element is itself increasing
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int maxi = 1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);

        }
        return maxi;
    }

    public static void printLIS(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        Arrays.fill(hash, 1);

        for (int i = 0; i <= n - 1; i++) {

            hash[i] = i; // initializing with current index
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {

                if (arr[prev_index] < arr[i] && 1 + dp[prev_index] > dp[i]) {
                    dp[i] = 1 + dp[prev_index];
                    hash[i] = prev_index;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i <= n - 1; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[lastIndex]);

        while (hash[lastIndex] != lastIndex) { // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);
        }

        // reverse the array

        System.out.print("The subsequence elements are ");

        for (int i = temp.size() - 1; i >= 0; i--) {
            System.out.print(temp.get(i) + " ");
        }
        System.out.println();

    }

    public int solveUsingBS(int[] num) {
        int[] ans = new int[num.length];
        int length = 1; // Initial length of the result array
        ans[0] = num[0]; // Initial state

        for (int i = 1; i < num.length; i++) {
            if (num[i] > ans[length - 1]) {
                // If num[i] is greater than the last element, extend the sequence
                ans[length] = num[i];
                length++;
            } else {
                // Find the position to replace using binary search
                int index = Arrays.binarySearch(ans, 0, length, num[i]);
                if (index < 0) {
                    index = -(index + 1); // Adjust for the insertion point
                }
                // Replace the element at the found index
                ans[index] = num[i];
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int ind = 0;
        int prev = -1;
        int n = nums.length;
        // int ans = solveUsingRec(nums, ind, prev);

        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        // int ans = solveUsingMem(nums, ind, prev, dp);

        // int ans = solveUsingTabulation(nums);
        int ans = optimizeDP(nums);
        System.out.println(ans);
        // printLIS(nums);

    }
}
