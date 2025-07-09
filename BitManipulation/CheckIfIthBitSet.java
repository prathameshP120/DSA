public class CheckIfIthBitSet {
    public static void checkithBitSet_Using_Right_shift(int n, int i) {
        if (((n >> i) & 1) == 1) {
            System.out.println("the " + i + "th bit is set");
        } else {
            System.out.println(i + "the ith bit is not set ");
        }
    }

    public static void checkithBitSet_Using_Left_shift(int n, int i) {
        if (((1 << i) & n) != 0) {
            System.out.println("the " + i + "th bit is set");
        } else {
            System.out.println(i + "the ith bit is not set ");
        }
    }

    public static void main(String[] args) {
        int n = 13; // 1101
        int i = 2;
        // we have to check that the 2th bit is one or not
        checkithBitSet_Using_Right_shift(n, i);
        checkithBitSet_Using_Left_shift(n, i);

    }
}
