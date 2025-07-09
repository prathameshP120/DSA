public class PermutationOfString {

    public static void FindPermutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            String Newstr = str.substring(0, i) + str.substring(i + 1, str.length());

            FindPermutation(Newstr, ans + curr);

        }
    }

    public static void main(String[] args) {
        String str = "abc";
        FindPermutation(str, "");
    }

}

/*
 * 
 * 
 * class Solution {
 * public List<List<Integer>> permute(int[] nums) {
 * List<List<Integer>> result = new ArrayList<>(); // Result to store
 * permutations
 * findPermutations(nums, new ArrayList<>(), result); // Call helper function
 * return result; // Return the final result
 * }
 * 
 * private void findPermutations(int[] nums, List<Integer> current,
 * List<List<Integer>> result) {
 * // Base case: If the current permutation is the same size as nums, add it to
 * result
 * if (current.size() == nums.length) {
 * result.add(new ArrayList<>(current)); // Add a copy of the current list
 * return;
 * }
 * 
 * // Iterate over the array and build permutations
 * for (int i = 0; i < nums.length; i++) {
 * if (current.contains(nums[i])) {
 * continue; // Skip if the number is already used in the current permutation
 * }
 * current.add(nums[i]); // Add the current number to the permutation
 * findPermutations(nums, current, result); // Recursively call for the next
 * permutation
 * current.remove(current.size() - 1); // Backtrack by removing the last element
 * }
 * }
 * }
 * 
 * 2] method using ArrayList of string
 * class Solution {
 * public List<String> permute(String s) {
 * List<String> result = new ArrayList<>(); // Result list to store permutations
 * findPermutations(s, "", result); // Call the helper function
 * return result; // Return the final result list
 * }
 * 
 * private void findPermutations(String s, String current, List<String> result)
 * {
 * // Base case: When the current permutation is of the same length as the
 * original string
 * if (current.length() == s.length()) {
 * result.add(current); // Add the permutation to the result
 * return;
 * }
 * 
 * // Iterate over the characters in the string
 * for (int i = 0; i < s.length(); i++) {
 * // Skip characters already used in the current permutation
 * if (current.contains(String.valueOf(s.charAt(i)))) {
 * continue;
 * }
 * // Add the current character and recursively generate permutations
 * findPermutations(s, current + s.charAt(i), result);
 * }
 * }
 * }
 * 
 * 
 * 
 * 
 */
