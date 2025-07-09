
// 370. Range Addition
// Assume you have an array of length n initialized with all 0's and are given k update operations.

// Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

// Return the modified array after all k operations were executed.

// Example:

// Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
// Output: [-2,0,3,5,3]
import java.util.*;

public class AdditionRange {

    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length + 1];

        // Apply updates using a difference array
        for (int[] update : updates) {
            arr[update[0]] += update[2];
            if (update[1] + 1 < arr.length) {
                arr[update[1] + 1] -= update[2];
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
            System.out.println();
            System.out.println();
        }

        // Compute the prefix sum to finalize the values
        for (int i = 1; i < length; ++i) {
            arr[i] += arr[i - 1];
        }

        // Remove the extra element
        return Arrays.copyOf(arr, length);

    }

    public static void main(String[] args) {
        int length = 5;
        int updates[][] = { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } };
        int ans[] = getModifiedArray(length, updates);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

}
