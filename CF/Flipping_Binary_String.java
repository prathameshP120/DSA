import java.util.*;

public class Flipping_Binary_String{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            List<Integer> ones = new ArrayList<>();
            List<Integer> zeros = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    ones.add(i + 1);   // 1-based
                } else {
                    zeros.add(i + 1);
                }
            }

            // Case 1: even number of ones
            if (ones.size() % 2 == 0) {
                System.out.println(ones.size());
                for (int idx : ones) {
                    System.out.print(idx + " ");
                }
                System.out.println();
            }
            // Case 2: odd number of zeros
            else if (zeros.size() % 2 == 1) {
                System.out.println(zeros.size());
                for (int idx : zeros) {
                    System.out.print(idx + " ");
                }
                System.out.println();
            }
            // Impossible
            else {
                System.out.println(-1);
            }
        }
        sc.close();
    }
}