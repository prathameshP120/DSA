// Example 1:
// Input Format: N = 3, k = 5, array[] = {2,3,5}
// Result: 2
// Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

// Example 2:
// Input Format: N = 3, k = 1, array[] = {-1, 1, 1}
// Result: 3
// Explanation: The longest subarray with sum 1 is {-1, 1, 1}. And its length is 3.

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK_positive_negative_Element {
    public static int getLongestSubarray(int []a, int k) {
        int n = a.length; // size of the array.

        Map<Integer, Integer> hm= new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            

            //Calculate the length and update maxLen:
            if (hm.containsKey(sum - k)) {
                int len = i - hm.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {
        int k = 5;
        int arr[] = {2,3,5};
        //optimal
        //either the prefixsum==k or 
        // (prefixSum-k) present inside the hash map which indicate that subarray lies between them 
        int ans=getLongestSubarray(arr, k);
        System.out.println(ans);
    }
}
