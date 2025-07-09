import java.util.ArrayList;
import java.util.List;

public class Palindromic_partition {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        recursive(s, 0, new ArrayList<>(), result);
        return result;
    }

    public static void recursive(String s, int start, List<String> path,
            List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Explore all possible partitions
        for (int end = start + 1; end <= s.length(); end++) {
            // If the current substring is a palindrome, add it to the current path
            if (isPalindrome(s, start, end - 1)) {
                path.add(s.substring(start, end));

                // Recur to find other partitions
                recursive(s, end, path, result);
                // Backtrack to explore other partitions
                path.remove(path.size() - 1);
                if (end == 4) {
                    System.out.println(path);
                }
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        // Check if the substring s[left:right+1] is a palindrome
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> ans = partition(str);
        System.out.println(ans);
    }
}

/*
 * start = 0, end = 1 --> "a" ✅
 * start = 1, end = 2 --> "a" ✅
 * start = 2, end = 3 --> "b" ✅
 * start = 3, end = 4 --> "b" ✅
 * start = 4 (Base case) --> ["a", "a", "b", "b"] ✅
 * Backtrack: Remove "b"
 * Backtrack: Remove "b"
 * start = 2, end = 4 --> "bb" ✅
 * start = 4 (Base case) --> ["a", "a", "bb"] ✅
 * Backtrack: Remove "bb"
 * Backtrack: Remove "a"
 * start = 1, end = 3 --> "ab" ❌
 * start = 1, end = 4 --> "abb" ❌
 * Backtrack: Remove "a"
 * start = 0, end = 2 --> "aa" ✅
 * start = 2, end = 3 --> "b" ✅
 * start = 3, end = 4 --> "b" ✅
 * start = 4 (Base case) --> ["aa", "b", "b"] ✅
 * Backtrack: Remove "b"
 * Backtrack: Remove "b"
 * start = 2, end = 4 --> "bb" ✅
 * start = 4 (Base case) --> ["aa", "bb"] ✅
 * Backtrack: Remove "bb"
 * Backtrack: Remove "aa"
 * start = 0, end = 3 --> "aab" ❌
 * start = 0, end = 4 --> "aabb" ❌
 * 
 */