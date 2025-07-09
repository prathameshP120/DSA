import java.util.*;

public class NGEOne {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Stack<Integer> numStack = new Stack<>();
        Map<Integer, Integer> NumberNGE = new HashMap<>();
        numStack.push(nums2[nums2.length - 1]);
        NumberNGE.put(nums2[nums2.length - 1], -1);

        for (int i = nums2.length - 2; i >= 0; i--) {
            if (nums2[i] < numStack.peek()) {
                NumberNGE.put(nums2[i], numStack.peek());
                numStack.push(nums2[i]);
                continue;
            }

            while (!numStack.isEmpty() && numStack.peek() < nums2[i]) {
                numStack.pop();
            }
            if (numStack.isEmpty()) {
                numStack.push(nums2[i]);
                NumberNGE.put(nums2[i], -1);
            } else {
                NumberNGE.put(nums2[i], numStack.peek());
                numStack.push(nums2[i]);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = NumberNGE.get(nums1[i]);
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 2, 3 };
        int[] nums2 = { 1, 3, 4, 2 };
        /*
         * first time output is [I@28a418fc
         * The issue you're encountering is due to how you're trying to print the array
         * directly using System.out.print().
         * When you print an array directly like that, Java will output the array's
         * memory address rather than its contents.
         * To print the contents of the array in a human-readable format, you should use
         * Arrays.toString().
         * Here's how you can modify your main method to properly print the
         * contents of the nums1 array after finding the next greater elements:
         */

        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Print the array contents
    }
}
