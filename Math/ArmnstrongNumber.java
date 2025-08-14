public class ArmnstrongNumber {
    // An Amrstrong number is a number that is equal to the sum of its own digits
    // each raised to the power of the number of digits.
    public static boolean isArmstrong(int num) {
        int k = String.valueOf(num).length();
        int sum = 0;
        int n = num;

        while (n > 0) {
            // extract the last digit
            int lastD = n % 10;
            sum += Math.pow(lastD, k);
            n = n / 10;

        }
        
        return sum == num ? true : false;
        
    }

    public static void main(String[] args) {
        int n = 152; // 153
        System.out.println(isArmstrong(n));
    }

}
