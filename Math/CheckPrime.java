public class CheckPrime {
    // Brute force
    // Prime number is a number that is divisible by number 1 and number itself (1
    // is not prime )
    public static boolean usingBruteForce(int n) {
        // Tc=O(N) where N is the input number as we iterate from 1 to N performing
        // constant-time operation for each iteration.
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cnt++;
            }
        }
        if (cnt == 2) {
            return true;
        }
        return false;


    }

    public static boolean Optimal(int n) {
        if (n == 1) {
            return false;

        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 11;
        // boolean ans = usingBruteForce(n);
        // Optimal approach : iterate only up to the Square Root of n
        boolean ans = Optimal(n);
        System.out.println(ans);
    }
}
