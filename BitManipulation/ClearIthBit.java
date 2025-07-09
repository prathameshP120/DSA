public class ClearIthBit {
    public static int clearIthBit(int n, int i) {

        return ~(1 << i) & n;
    }

    public static void main(String[] args) {
        System.out.println(clearIthBit(10, 1));
        //10 => 1010
             // 0010
             // 1101
    }

}
