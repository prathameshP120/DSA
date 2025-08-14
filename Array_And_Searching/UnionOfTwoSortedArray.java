// Union of two sorted arrays
// Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.
// The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.
// Examples:
// Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]

// Output: [1, 2, 3, 4, 5, 7]

// Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2
import java.util.ArrayList;
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


//Inserting elements from nums1 into HashSet:
// n insertions into a HashSet: O(n) (average case, due to constant time insertions)
// Inserting elements from nums2 into HashSet:
// m insertions: O(m)
// Copying HashSet to array:
// k elements: O(k)
// Sorting the array:
// Sorting k elements: O(k log k)
// Printing the array:
// k elements: O(k)
// ✅ Total Time Complexity:
// O(n + m + k + k log k + k)
// = O(n + m + k log k)
    
   }
   public static void optimal(int nums1[], int nums2[]) {
    int n1 = nums1.length;
    int n2 = nums2.length;

    int i = 0, j = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    while (i < n1 && j < n2) {
        if (nums1[i] < nums2[j]) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != nums1[i]) {
                ans.add(nums1[i]);
            }
            i++;
        } else if (nums1[i] > nums2[j]) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != nums2[j]) {
                ans.add(nums2[j]);
            }
            j++;
        } else { // nums1[i] == nums2[j]
            if (ans.size() == 0 || ans.get(ans.size() - 1) != nums1[i]) {
                ans.add(nums1[i]);
            }
            i++;
            j++;
        }
    }

    while (i < n1) {
        if (ans.size() == 0 || ans.get(ans.size() - 1) != nums1[i]) {
            ans.add(nums1[i]);
        }
        i++;
    }

    while (j < n2) {
        if (ans.size() == 0 || ans.get(ans.size() - 1) != nums2[j]) {
            ans.add(nums2[j]);
        }
        j++;
    }

    // Print result
    for (int k = 0; k < ans.size(); k++) {
        System.out.print(ans.get(k) + " ");
    }
//⏱️ Final Time Complexity:
// ✅ O(n1 + n2)

// This is optimal because it processes each element once without sorting or extra scanning.

// 📦 Space Complexity:
// ✅ O(n1 + n2) (in the worst case when all elements are distinct)


    
}


       
    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 4, 5};
        int nums2[] = {1, 2, 7};

        //BruteForce(nums1, nums2); // Output: 1 2 3 4 5 7
        //Optimal solution 
        optimal(nums1,nums2);
        
    }
}