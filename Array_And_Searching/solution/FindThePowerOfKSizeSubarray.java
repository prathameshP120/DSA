// You are given an array of integers nums of length n and a positive integer k.

// The power of an array is defined as:

// Its maximum element if all of its elements are consecutive and sorted in ascending order.-1 otherwise.You need to find the power of all subarrays of nums of size k.

// Return an integer array results of size n-k+1,where results[i]is the power of nums[i..(i+k-1)].

// Example 1:

// Input:nums=[1,2,3,4,3,2,5],k=3

// Output:[3,4,-1,-1,-1]

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.DelayQueue;

import java.util.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public class FindThePowerOfKSizeSubarray {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n - k + 1]; // Result array for sliding window size k
        int resIndex = 0; // Index for filling the result array

        // Iterate over each element in nums array
        for (int i = 0; i < n; i++) {
            // Remove elements out of the sliding window range
            while (!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }

            // Remove elements not satisfying the condition
            while (!dq.isEmpty() && nums[dq.getLast()] != nums[i] - 1) {
                dq.removeLast();
            }

            // Add the current index to the deque
            dq.addLast(i);

            // If the sliding window is ready, process the result
            if (i >= k - 1) {
                if (dq.size() == k) {
                    res[resIndex++] = nums[dq.getLast()];
                } else {
                    res[resIndex++] = -1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindThePowerOfKSizeSubarray ans = new FindThePowerOfKSizeSubarray();
        int[] nums = { 1, 2, 3, 4, 3, 2, 5 };
        int k = 3;
        int[] result = ans.resultsArray(nums, k);

        // Print output
        System.out.println("Output: " + Arrays.toString(result));
    }
}

/*
 * 
 * j nums[j] nums[j+1] nums[j] + 1 Condition nums[j] + 1 != nums[j+1]
 * 0 1 2 1 + 1 = 2 ❌ (2 == 2, condition false)
 * 1 2 3 2 + 1 = 3 ❌ (3 == 3, condition false)
 * 
 * 
 * 
 */