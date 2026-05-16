import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();   // number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();   // number of colors

            int max = -1;
            int index = -1;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();  // count of color i+1

                if (x > max) {
                    max = x;
                    index = i + 1;  // store 1-based index
                }
            }

            System.out.println(index);
        }

        sc.close();
    }
}