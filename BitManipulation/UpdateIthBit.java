public class UpdateIthBit {
    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return ~(1 << i) & n;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        n = clearIthBit(n, 0);

        return (newBit << i) | n;
    }

    public static void main(String[] args) {
        System.out.println(updateIthBit(10, 2, 1));
    }

}
