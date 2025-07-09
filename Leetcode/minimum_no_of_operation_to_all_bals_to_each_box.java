/*
You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
Each answer[i] is calculated considering the initial state of the boxes.
Example 1:

Input: boxes = "110"
Output: [1,1,3]   
 */

public class minimum_no_of_operation_to_all_bals_to_each_box {
    public int[] minOperations(String boxes) {
        // sum-number of operation to move the right ones
        // prefixSum-number of operation to move the left ones
        // so firt case is for finding the sum which is for index=0
        int sum = 0;
        int n = boxes.length();
        int right_ones = 0;
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                sum += i;
                right_ones++;
            }
        }

        // calculate moves per position
        int res[] = new int[n];
        int left_ones = 0;
        int prefix_sum = 0;
        int moves = 0;
        for (int i = 0; i < n; i++) {
            moves = prefix_sum + sum;
            res[i] = moves;

            // update while moving to the right
            if (boxes.charAt(i) == '1') {
                right_ones--;
                left_ones++;

            }
            prefix_sum += left_ones;
            sum -= right_ones;

        }

        return res;
    }

}
