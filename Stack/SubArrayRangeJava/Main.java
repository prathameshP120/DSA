package SubArrayRangeJava;
import java.util.*;
class Sum_of_Subarray_Range {

    public int[] findNSE(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] findPSE(int[] nums) {
        int n = nums.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    public long sumSubarrayMins(int[] nums) {
        int[] nse = findNSE(nums);
        int[] pse = findPSE(nums);

        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            total += (long) left * right * nums[i];
        }
        return total;
    }

    public int[] findNGE(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    public int[] findPGE(int[] nums) {
        int n = nums.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }

    public long sumSubarrayMax(int[] nums) {
        int[] nge = findNGE(nums);
        int[] pge = findPGE(nums);

        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i - pge[i];
            int right = nge[i] - i;
            total += (long) left * right * nums[i];
        }
        return total;
    }

    public long subArrayRanges(int[] nums) {
        long maxSum = sumSubarrayMax(nums);
        long minSum = sumSubarrayMins(nums);
        return maxSum - minSum;
    }
}
public class Main{
    public static void main(String[] args) {
        Sum_of_Subarray_Range obj = new Sum_of_Subarray_Range();
        int[] nums = {1, 3, 3};
        System.out.println(obj.subArrayRanges(nums)); // Output: 4
    }
}
// For running the above code 
// PS C:\Users\hp\Desktop\DSA-ALL\Stack\SubArrayRangeJava> cd ../
// PS C:\Users\hp\Desktop\DSA-ALL\Stack> javac SubArrayRangeJava/Main.java
// >>
// PS C:\Users\hp\Desktop\DSA-ALL\Stack> java SubArrayRangeJava.Main
// >>
// 4
// PS C:\Users\hp\Desktop\DSA-ALL\Stack>
