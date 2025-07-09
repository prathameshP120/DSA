import java.util.*;

public class LeftShiftRightShift {
    public static void stringShift(String s, int shift[][]) {
        if (s == null || s.isEmpty()) {
            System.out.println("String is empty");
        }

        int n = s.length();
        int netShift = 0;
        for (int row[] : shift) {
            if (row[0] == 0) {
                netShift -= row[1];
            } else {
                netShift += row[1];
            }
        }
        netShift = (netShift % n + n) % n;
        if (netShift < 0) {
            netShift += n; // Adjust for negative shifts
        }
        System.out.println(netShift);
        // this is nothing but the righShift
        String str = s.substring(n - netShift) + s.substring(0, n - netShift);
        System.out.println(str);
    }

    public static void main(String[] args) {
        String s = "abc";
        // 0=> means left shift
        // 1=>means right shift
        int[][] shift = { { 0, 1 }, { 1, 2 } };
        stringShift(s, shift);
    }
}
