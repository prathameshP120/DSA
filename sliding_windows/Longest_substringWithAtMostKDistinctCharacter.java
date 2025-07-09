package sliding_windows;

import java.util.HashMap;

public class Longest_substringWithAtMostKDistinctCharacter {
    public static int ans(String s, int k) {
        int l = 0;
        int r = 0;
        int maxlen = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int n = s.length();
        while (r < n) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            while (hm.size() > k) {
                hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) - 1);
                if (hm.get(s.charAt(r)) == 0) {
                    hm.remove((s.charAt(r)));
                }
                l++;
            }
            if (hm.size() <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = "aaabbccd";
        int k = 2;
        System.out.println(ans(s, k));
    }
}
// PS C:\Users\patil\OneDrive\Desktop\DSA-ALL> java
// sliding_windows.Longest_substringWithAtMostKDistinctCharacter
// 5
// tc=o(n+n)
// sc=O(how many character you are saving in hashMap)