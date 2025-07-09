public class conversionBtoD_D_B {
    public static void convert_Decimal_to_Binary(int n) {
        String str = "";
        while (n != 1) {
            if (n % 2 == 1) {
                str += "1";
            } else {
                str += "0";
            }
            n /= 2;
        }
        if (n == 1) {
            str += "1";
        }
        StringBuilder sb = new StringBuilder(str);
        String reversedString = sb.reverse().toString();
        System.out.println(reversedString);
    }

    public static void convert_Binary_to_Decimal(String str) {

        int n = str.length();
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            int bit = str.charAt(i) - '0'; // as str cointain 0 or 1 not character . for char int num=ch-'a';
            ans += bit * Math.pow(2, n - i - 1);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int n = 13;
        // convert decimal to binary
        convert_Decimal_to_Binary(n);
        // convert binary to decimal
        String str = "1101";
        convert_Binary_to_Decimal(str);
    }
}
