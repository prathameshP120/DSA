public class ClearLastBit {
    public static int ClearLastIthBit(int n, int i) {
        int bitMask = (~0) << i;
        return bitMask & n;

    }

    public static void main(String[] args) {
        System.out.println(ClearLastIthBit(15, 2));
    }
}
