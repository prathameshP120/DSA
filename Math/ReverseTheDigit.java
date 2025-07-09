public class ReverseTheDigit {
    // Extracting the last digit from number n => n%10;
    // For removing the last digit from the number n=> n/10

    public static void main(String[] args) {
        int n = 647;
        int reverseNum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            reverseNum = reverseNum * 10 + lastDigit;
            // remove the last digit form the n
            n /= 10;
        }
        System.out.println(reverseNum);

    }
}
/*
 * Time Complexity: O(log10N + 1) where N is the input number. The time
 * complexity is determined by the number of digits in the input integer N. In
 * the worst case when N is a multiple of 10 the number of digits in N is log10
 * N + 1.
 * 
 * In the while loop we divide N by 10 until it becomes 0 which takes log10N
 * iterations.
 * In each iteration of the while loop we perform constant time operations like
 * modulus and division and pushing elements into the vector
 */
