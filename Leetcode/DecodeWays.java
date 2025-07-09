public class DecodeWays {
    public static int TotalDecodeWays(String s) {
        int n = s.length();
        // Edge case: if string is empty, return 0
        if (n == 0)
            return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: there's one way to decode an empty string

        // Check if the first character is '0'
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            // Check the one-digit number
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            // Check the two-digit number
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n]; // The result is in dp[n]
    }

    public static void main(String[] args) {
        String str = "122016";
        int result = TotalDecodeWays(str);
        System.out.println("Total number of decode ways: " + result);
    }
}
