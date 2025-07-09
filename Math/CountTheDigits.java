public class CountTheDigits {
    public static void main(String[] args) {
        int n = 1246305;
        int cnt = 0;
        while (n > 0) {
            cnt += 1;
            n /= 10;
        }
        System.out.println("The number of digits in the given numbers are : " + cnt);
    }
}
/*
 * Complexity Analysis
 * Time Complexity: O(log10N + 1) where N is the input number. The time
 * complexity is determined by the number of digits in the input integer N. In
 * the worst case when N is a multiple of 10 the number of digits in N is log10N
 * + 1.
 * In the while loop we divide N by 10 until it becomes 0 which takes log10N
 * iterations.
 * In each iteration of the while loop we perform constant time operations like
 * division and increment the counter.
 */