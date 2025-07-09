// Union of two sorted arrays
// Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.
// The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.
// Examples:
// Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]

// Output: [1, 2, 3, 4, 5, 7]

// Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2
import java.util.HashSet;

public class UnionOfTwoSortedArray {

    public static void BruteForce(int nums1[], int nums2[]) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int ele : nums1) {
            set.add(ele);
        }
        for (int ele : nums2) {
            set.add(ele);
        }

        // Copy set elements into array
        int[] ans = new int[set.size()];
        int j = 0;
        for (int val : set) {
            ans[j++] = val;
        }

        // Sort the result to maintain ascending order
        java.util.Arrays.sort(ans);

        // Print the result
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 4, 5};
        int nums2[] = {1, 2, 7};

        //BruteForce(nums1, nums2); // Output: 1 2 3 4 5 7
        //Optimal solution 
        
    }
}
