
/*
You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k.
Each minute, you may take either the leftmost character of s, or the rightmost character of s.
Return the minimum number of minutes needed for you to take at least k of each character,
or return -1 if it is not possible to take k of each character.
Example 1:
Input: s = "aabaaaacaabc", k = 2
Output: 8 

*/
import java.util.*;

public class Take_K_0f_Each_from_left_and_right {
    public static int result(String s, int k) {
        int count[] = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int minLen = s.length();
        if ((Math.min(Math.min(count[0], count[1]), count[2])) < k) {
            return -1;
        }
        int n = s.length();
        int l = 0;
        int maxlen = Integer.MIN_VALUE;
        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            count[c - 'a']--;
            if ((Math.min(Math.min(count[0], count[1]), count[2])) < k) {
                count[s.charAt(l) - 'a']++;
                l++;

            }
            maxlen = Math.max(maxlen, r - l + 1);

        }
        int minlen = n - maxlen;
        return minlen;

    }

    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;
        int ans = result(s, k);
        System.out.println(ans);

    }
}
