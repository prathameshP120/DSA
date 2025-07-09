import java.util.ArrayList;

public class leetcode {
    public static ArrayList<ArrayList<Integer>> permutation(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        findPermutation(nums, new ArrayList<>(), res);
        return res;
    }

    public static void findPermutation(int nums[], ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) {
                continue;
            }
            curr.add(nums[i]);
            // recursion
            findPermutation(nums, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.print(permutation(nums));
    }
}
