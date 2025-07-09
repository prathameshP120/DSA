import java.util.Arrays;
import java.util.Stack;

public class NGE_Right {
    public static int[] nextGreaterElements(int nums[]) {
        Stack<Integer> s = new Stack<>();
        int n = nums.length;
        int nextGreater[] = new int[n];
        //SC=O(n)+O(n)
        for (int i = n - 1; i >= 0; i--) {   //these for loop will take O(n)
            while (!s.isEmpty() && nums[i] >= nums[s.peek()]) {   //these can be remove the n element from the stack TC=O(n), so our Total TC=O(2n)
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = nums[s.peek()];
            }
            s.push(i);
        }
        return nextGreater;
    }
 
    public static void main(String[] args) {
        //here if we apply brute force then it will take O(n^2) and so we use stack 
        int nums[] = { 6, 8, 0, 1, 3 };
        int ans[] = nextGreaterElements(nums);
        System.out.println(Arrays.toString(ans));

    }
}
// Why Store Indices Instead of Elements Directly?
// Accessing the Original Array is Easy:

// When you store indices, you can always refer back to the original array (nums[index]) to get the element.

// If you stored elements directly, you wouldn't know their original positions, which might be needed for comparisons.