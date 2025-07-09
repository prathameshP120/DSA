
/*
You are given an integer array nums and an integer k. 
Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions.
If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

  


 */

import java.util.HashMap;

public class Max_of_Distinct_SubArray_with_length_k {
    public static long result(int nums[], int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int lastSum = 0;
        int l = 0;
        int r;
        for (r = 0; r < k; r++) {
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);
            lastSum += nums[r];
        }
        long sum = 0;

        while (r < n) {
            // if hashMap is distinct =>
            if (hm.size() == k) {
                sum = Math.max(sum, lastSum);
            }
            // shifting the window
            // shift the left pointer and remove that element if its frequence becomes zero
            if (l < n) {
                hm.put(nums[l], hm.getOrDefault(nums[l], 0) - 1);
                if (hm.get(nums[l]) == 0) {
                    hm.remove(nums[l]);
                }
                lastSum -= nums[l];
                l++;
            }

            // move right pointer and adding the right element to window
            if (r < n) {
                hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);
                lastSum += nums[r];
            }
            r++;

        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;
        long ans = result(nums, k);
        System.out.println(ans);
    }
}
