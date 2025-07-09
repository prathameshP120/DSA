import java.util.*;

public class ValidAnagram { // O(n) && //O(n)
    public static boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) { // O(1)
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) - 1);
                if (hm.get(ch) == 0) {
                    hm.remove(ch);
                }
            } else {
                return false;
            }
        }

        return hm.isEmpty();
    }

    public static void main(String[] args) {
        String s = "knee";
        String t = "keen";
        System.out.println(validAnagram(s, t)); // should print true
    }
}
