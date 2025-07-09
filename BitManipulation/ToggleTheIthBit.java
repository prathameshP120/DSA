public class ToggleTheIthBit {
    public static void toggle_the_IthBIt(int n, int i) {
        // we know that xor gives 0 => if the number of bit is even
        int ans = (1 << i) ^ n;
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int n = 13;
        int i = 2;
        // 1101 =>1001
        toggle_the_IthBIt(n, i);
    }
}
