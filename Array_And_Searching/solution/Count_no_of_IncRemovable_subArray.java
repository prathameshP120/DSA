/*
   A subarray of nums is called incremovable if nums becomes strictly increasing on removing the subarray. For example, the subarray [3, 4] is an incremovable subarray of [5, 3, 4, 6, 7] because removing this subarray changes the array [5, 3, 4, 6, 7] to [5, 6, 7] which is strictly increasing.

Return the total number of incremovable subarrays of nums.
 */

public class Count_no_of_IncRemovable_subArray {
    public static boolean isIncRemovable(int nums[], int s, int e) {
        int prev = 0; // last seen less element
        for (int k = 0; k < nums.length; k++) {
            if (k >= s && k <= e) {
                continue;
            }
            if (prev >= nums[k]) {
                return false;
            }
            prev = nums[k];
        }
        return true;
    }

    public static int count(int nums[]) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // We check if the given array is incremovable or not
                if (isIncRemovable(nums, i, j)) {
                    count++;
                }

            }
        }
        return count;

    }

    public static void main(String args[]) {
        int nums[] = { 6, 5, 7, 8 };
        int ans = count(nums);
        System.out.println(ans);
    }
}