public class CountTheNumberOfSetBits {
    public static void count_The_setBits(int n) {
        int cnt = 0;
        // while (n > 1) {
        // if (n % 2 == 1) { // you can also do this as (n & 1)
        // cnt++;
        // }
        // n /= 2;
        // }
        while (n > 1) {
            cnt += n & 1; // it check if number is odd or even
            n = n >> 1; // this is equivalent to n/2
        }
        if (n == 1) {
            cnt++;
        }
        System.out.println(cnt);
    }

    // in binary search you can calculate the number of set bits
    // mid=(low+high)>>1
    public static void main(String[] args) {
        int n = 7;
        count_The_setBits(n);
    }
}
