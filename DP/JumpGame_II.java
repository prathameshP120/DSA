/*  45. Jump Game II
 You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 0 <= j <= nums[i] and
  i + j < n
 Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
*/

public class JumpGame_II {

    public static int recursion(int nums[], int index) {
        int n = nums.length;
        if (index >= n - 1) {
            return 0; // No more jumps needed if at last index
        }

        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            if (index + i < n) {
                int jumps = recursion(nums, index + i);
                minJumps = Math.min(minJumps, jumps + 1);
            }
        }
        return minJumps;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, 1, 1, 4 };
        int ans = recursion(nums, 0);
        System.out.println(ans);
    }
}
