import java.util.*;

public class LeftShiftRightShift {
   public static void stringShift(String s, int[][] shift) {
    int netShift = 0;

    for (int[] row : shift) {
        if (row[0] == 0) {      // left shift
            netShift -= row[1];
        } else {               // right shift
            netShift += row[1];
        }
    }

    int n = s.length();
    netShift = netShift % n;
    if (netShift < 0) {
        netShift += n;
    }

    // RIGHT shift
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
