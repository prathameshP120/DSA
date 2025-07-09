/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

*/
public class ZigZagconversion {
    public static String convert(String s, int nr) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        // traverse through each row one by one print it
        for (int i = 0; i < nr; i++) {
            // idx will traverse in row i
            int idx = i;
            int southDelta = 2 * (nr - 1 - i);
            int northDelta = 2 * i;
            while (idx < s.length()) {
                str.append(s.charAt(idx));
                boolean goSouth = true;
                if (i == 0) {
                    idx += southDelta;
                } else if (i == nr - 1) {
                    idx += northDelta;
                } else {
                    if (goSouth) {
                        idx += southDelta;
                    } else {
                        idx += northDelta;
                    }
                    goSouth = !goSouth;
                }

            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String str = convert(s, numRows);
        System.out.println(str);
    }
}