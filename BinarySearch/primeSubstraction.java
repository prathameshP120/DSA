import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int lb = lowerBound(nums, i + 1, n, lower - nums[i]); // lower bound
            int up = upperBound(nums, i + 1, n, upper - nums[i]); // upper bound
            ans += (up - lb);
        }
        return ans;
    }

    // Method to find lower bound
    private int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // Method to find upper bound
    private int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}