public class Subset_String {
    public static void findSubsets(String str, String ans, int i) {
        if (i == str.length()) {
            if (str.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // Yes
        findSubsets(str, ans + str.charAt(i), i + 1);
        // No
        findSubsets(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str, " ", 0);
    }

}
/*
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 * class Solution {
 * public List<List<Integer>> subsets(int[] nums) {
 * List<List<Integer>> result = new ArrayList<>();
 * findSubsets(nums, new ArrayList<>(), 0, result);
 * return result;
 * }
 * 
 * private void findSubsets(int[] nums, List<Integer> current, int
 * index,List<List<Integer>> result) {
 * if (index == nums.length) {
 * result.add(new ArrayList<>(current));
 * return;
 * }
 * 
 * // Include the current element
 * current.add(nums[index]);
 * findSubsets(nums, current, index + 1, result);
 * 
 * // Exclude the current element
 * current.remove(current.size() - 1);
 * findSubsets(nums, current, index + 1, result);
 * }
 * }
 * 
 */