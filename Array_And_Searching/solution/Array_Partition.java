
//Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
import java.util.*;

public class Array_Partition {
    public static int partition(int nums[]) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            ans += Math.min(nums[i], nums[i + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 6, 2, 6, 5, 1, 2 };
        System.out.println(partition(nums));
    }
}
