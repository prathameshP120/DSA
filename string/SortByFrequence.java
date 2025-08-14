public class SortByFrequence {
    
}
import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Array to store frequency and character, using index for ASCII
        Pair[] hash = new Pair[123]; // ASCII of 'z' is 122

        for (int i = 0; i < hash.length; i++) {
            hash[i] = new Pair(0, (char)i);
        }

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            hash[c].freq++;
        }

        // Sort by frequency in ascending order
        Arrays.sort(hash, (a, b) -> Integer.compare(a.freq, b.freq));

        StringBuilder res = new StringBuilder();

        // Add characters to result based on frequency, highest freq comes last (to be added at front)
        for (Pair p : hash) {
            if (p.freq > 0) {
                String temp = String.valueOf(p.ch).repeat(p.freq);
                res.insert(0, temp); // same as: res = temp + res
            }
        }

        return res.toString();
    }

    // Helper Pair class
    static class Pair {
        int freq;
        char ch;

        Pair(int f, char c) {
            freq = f;
            ch = c;
        }
    }
}
