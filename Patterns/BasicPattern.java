public class BasicPattern {
    public static void pattern_one() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern_Two() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= 4 - i - 1; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    // half Pyramid pattern
    public static void pattern_three() {
        for (int i = 0; i < 4; i++) {
            for (int num = 1; num <= i + 1; num++) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // character pattern Capital A/BC/DEF/GHIJ
    public static void char_Pattern() {
        int n = 4;
        char ch = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }

    // rectangle for * ( BIG Hole in it ) pattern of 5 BY 4
    public static void rectangle_pattern() {
        int n = 4;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || i == 3 || j == 0 || j == 4) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print(" " + " ");
                }
            }
            System.out.println();
        }
    }

    // inverted rotated half pyramid => [SSS*/SS**/S***/****]
    public static void inverted_Rotated_half_Pyramid() {
        int n = 4;
        for (int i = 0; i < n; i++) {
            // for printing space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" " + " ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    // Floyd's Triangle

    public static void floyd_pattern() {
        int num = 1;
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();

        }
    }

    // 01_triangle=>1/01/101/0101/10101
    public static void One_Zero_triangle() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1" + " ");
                } else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
    }
// ButterFly Pattern 
    public static void main(String[] args) {
        // pattern_one();
        // pattern_Two();
        // pattern_three();
        // char_Pattern();
        // rectangle_pattern();
        // inverted_Rotated_half_Pyramid();
        // floyd_pattern();
        // One_Zero_triangle();
    }
}