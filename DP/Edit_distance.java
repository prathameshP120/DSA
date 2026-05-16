import java.util.Arrays;

public class Edit_distance {
    
      public int rec(int i, int j, String s1, String s2) {
        if (j < 0) return i + 1;
        if (i < 0) return j + 1;

        // ✅ If characters match → no cost
        if (s1.charAt(i) == s2.charAt(j)) {
            return rec(i - 1, j - 1, s1, s2);
        }

        // ❌ If not match → try all 3 operations
        int insert = rec(i, j - 1, s1, s2);
        int remove = rec(i - 1, j, s1, s2);
        int replace = rec(i - 1, j - 1, s1, s2);

        return 1 + Math.min(insert, Math.min(remove, replace));
    }

    public static int solveUsingMem(String a, String b, int i, int j, int dp[][]) {
        if (b.length() == j) {
            return a.length() - i;
        }
        if (a.length() == i) {
            return b.length() - i;
        }
        // if ans is already exist
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 0;
        if (a.charAt(i) == b.charAt(j)) {
            ans = 1 + solveUsingMem(a, b, i + 1, j + 1, dp);

        } else {
            int replace = 1 + solveUsingMem(a, b, i + 1, j + 1, dp);
            int insert = 1 + solveUsingMem(a, b, i, j + 1, dp);
            int delete = 1 + solveUsingMem(a, b, i + 1, j, dp);

            ans = Math.min(replace, Math.min(insert, delete));

        }
        dp[i][j] = ans;
        return dp[i][j];

    }

    public static int solveUsingTabulation(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) { // simple move backward of both the indexes
                    dp[i][j] = 0 + dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];

    }

    public static int solveUsingTabulationSO(String a, String b) {
        int[] curr = new int[a.length() + 1];
        int[] next = new int[a.length() + 1];

        for (int row = 0; row <= a.length(); row++) {
            next[row] = a.length() - row;
        }

        for (int j = b.length() - 1; j >= 0; j--) {
            curr[a.length()] = b.length() - j;
            for (int i = a.length() - 1; i >= 0; i--) {
                int ans = 0;
                if (a.charAt(i) == b.charAt(j)) {
                    ans = 0 + next[i + 1];
                } else {
                    int replace = 1 + next[i + 1];
                    int insert = 1 + next[i];
                    int remove = 1 + curr[i + 1];
                    ans = Math.min(insert, Math.min(remove, replace));
                }
                curr[i] = ans;
            }
            next = Arrays.copyOf(curr, curr.length);
        }
        return next[0];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int i = word1.length();
        int j = word2.length();
        // int ans = solveUsingRec(word1, word2, i - 1, j - 1);

        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solveUsingTabulation(word1, word2);
        System.out.println(ans);
    }
}
