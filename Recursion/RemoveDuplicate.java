import java.util.*;

public class RemoveDuplicate {
    public static void removeDuplicate(String str, int idx, StringBuilder newstr, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(newstr);
            return;
        }
        char curr = str.charAt(idx);
        if (map[curr - 'a'] == true) {
            return removeDuplicate(str, idx + 1, newstr, map);
        } else {
            map[curr - 'a'] = true;
            return removeDuplicate(str, idx + 1, newstr.append(curr), map);
        }
    }

    public static void main(String[] args) {
        char str = "appannacollage";
        removeDuplicate(str, 0, StringBuilder = " ", new boolean[26]);

    }

}
