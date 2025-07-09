import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_in_circular_array {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nextGreater = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = nums[i % n];
            while (!s.isEmpty() && s.peek() <= curr) {
                s.pop();
            } 
            if (i < n) {          // assignment only possible for the element where i<n
                if (s.isEmpty()) {
                    nextGreater[i] = -1;
                }else{
                    nextGreater[i] = s.peek();
                }
            }
            s.push(curr);
        }

        return nextGreater;
    }

    public static void main(String[] args) {
        int nums[] = { 6, 8, 0, 1, 3 };
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
       //TC=2n (for loop) + n (total pops) = O(3n) ≈ O(n).
       //Sc=O(n)

       //Logic :
         //the array wil { 6, 8, 0, 1, 3 } , 6, 8,0,1,3
         // now the last index is 9 start for i=2*n-1 . we will find the nge only for i<n  


    }
}

/*
 * import java.util.Stack;
 * public class NextGreaterElement {
 * 
 * public static int[] nextGreaterElements(int[] nums) {
 * int n = nums.length;
 * int[] nextGreater = new int[n];
 * Stack<Integer> s = new Stack<>();
 * 
 * for (int i = 2 * n - 1; i >= 0; i--) {
 * int curr = nums[i % n];
 * while (!s.isEmpty() && s.peek() <= curr) {
 * s.pop();
 * }
 * if (i < n) {
 * if (s.isEmpty()) {
 * nextGreater[i] = -1;
 * } else {
 * nextGreater[i] = s.peek();
 * }
 * }
 * s.push(curr);
 * }
 * 
 * return nextGreater;
 * 
 * }
 * 
 * public static void main(String[] args) {
 * int nums[] = { 6, 8, 0, 1, 3 };
 * System.out.println(nextGreaterElements(nums));
 * }
 * }
 */