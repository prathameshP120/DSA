//GCD=> The Greatest Common Divisor of any two integers is the largest number that divides both integers.
//LCD=> 
public class GCD_LCD {
    public static int BruteForce(int n1, int n2) {

        // Initialize gcd to 1
        int gcd = 1;

        // Iterate from 1 up to
        // the minimum of n1 and n2
        for (int i = 1; i <= Math.min(n1, n2); i++) {
            // Check if i is a common
            // factor of both n1 and n2
            if (n1 % i == 0 && n2 % i == 0) {
                // Update gcd to the
                // current common factor i
                gcd = i;
            }
        }

        // Return the greatest
        // common divisor (gcd)
        return gcd;
    }

    public static int Euclidean_method(int a, int b) {

        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;

            }
        }
        if (a == 0) {
            return b;
        }
        return a;
    }

    public static void main(String[] args) {
        int n1 = 20, n2 = 15;

        // bruete force
        // int gcd = BruteForce(n1, n2); // Tc=O(min(n1,n2))
        // Euclidean Algorithm
        int gcd = Euclidean_method(n1, n2);
        System.out.println(gcd);
    }

}
/*
 * The Euclidean Algorithm is a method for finding the greatest common divisor
 * of two numbers. It operates on the principle that the GCD of two numbers
 * remains the same even if the smaller number is subtracted from the larger
 * number.
 * 
 * To find the GCD of n1 and n2 where n1 > n2:
 * 
 * Repeatedly subtract the smaller number from the larger number until one of
 * them becomes 0.
 * Once one of them becomes 0, the other number is the GCD of the original
 * numbers.
 * Eg, n1 = 20, n2 = 15:
 * 
 * gcd(20, 15) = gcd(20-15, 15) = gcd(5, 15)
 * 
 * gcd(5, 15) = gcd(15-5, 5) = gcd(10, 5)
 * 
 * gcd(10, 5) = gcd(10-5, 5) = gcd(5, 5)
 * 
 * gcd(5, 5) = gcd(5-5, 5) = gcd(0, 5)
 * 
 * Hence, return 5 as the gcd.
 * 
 * 
 */
