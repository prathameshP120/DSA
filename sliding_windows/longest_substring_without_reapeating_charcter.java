import java.util.Arrays;

public class longest_substring_without_reapeating_charcter {
    public static int LOLongestSubsUsingBruteForce(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        // here we try to generate all the possible substrings
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            // Initialize the hash array to keep
            // track of characters in the current substring

            // Using 256 to cover all ASCII characters
            int hash[] = new int[256];

            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] == 1) {
                    break;
                }
                maxLen = Math.max(maxLen, j - i + 1);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxLen;
        // Time Complexity: O(N2) where N is the length of the input string. The outer
        // loop runs from the starting to the end of the string and the inner loop from
        // the starting of the outer loop to the end.
        // In the best case, the inner loop breaks early when a repeating character is
        // found.
        // In the worst-case scenario, the inner loop runs through the length of the
        // string for each iteration of the outer loop leading to O(N x N) complexity.
        // Space Complexity : O(256) as a fixed array of size 256 to cover all ASCII
        // characters is used. This uses constant space and is not proportional to the
        // input values.

    }

    static int lengthOfLongestSubstring(String s) {

        // Array to store the last index
        // where each character occurred
        int[] hash = new int[256];

        // Initialize all elements
        // of the array to -1
        Arrays.fill(hash, -1);

        // Get the length of
        // the input string
        int n = s.length();

        // Pointers to keep track
        // of the current substring
        int l = 0, r = 0;

        // Variable to store the maximum
        // length of substring without
        // repeating characters
        int maxLen = 0;

        // Loop until the right pointer
        // reaches the end of the string
        while (r < n) {
            // If the current character
            // has been seen before
            if (hash[s.charAt(r)] != -1) {
                // If its last occurrence is
                // within the current substring
                if (hash[s.charAt(r)] >= l) {
                    // Move the left pointer to the
                    // position after the last occurrence
                    // of the current character
                    l = hash[s.charAt(r)] + 1;
                }
            }

            // Calculate the length
            // of the current substring
            int len = r - l + 1;

            // Update the maximum
            // length if needed
            maxLen = Math.max(len, maxLen);

            // Update the last occurrence
            // index of the current character
            hash[s.charAt(r)] = r;

            // Move the right pointer
            // to the next position
            r++;
        }
        // Return the maximum length of
        // substring without repeating characters
        return maxLen;
        // Time Complexity: O(N) where N is the length of the input string as we iterate
        // through the
        // string once with two pointers (l and r) and perform constant time operations
        // inside the loop.
        // Space Complexity : O(256) as a fixed array of size 256 to cover all ASCII
        // characters is used. This uses constant space and is not proportional to the
        // input values.
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Input String: " + s);
        // Using Bruete force
        int ans = LOLongestSubsUsingBruteForce(s);
        System.out.println();
        // Using Optimal Solution

        System.out.println(ans);

    }
}
