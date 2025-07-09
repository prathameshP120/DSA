public class SetIthBit {
    public static int setIthBit(int n, int i) {
        return n | 1 << i;
    }

    public static void main(String[] args) {
        // 10=> 1010
        // set 2 bit => 1110
        System.out.println(setIthBit(10, 2));
    }

}
