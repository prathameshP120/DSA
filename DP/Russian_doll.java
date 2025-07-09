import java.util.Arrays;

// here only 85/87 test cases are passed 
public class Russian_doll {

    private static boolean check(int[] curr, int[] prev) {
        // curr -> larger envelope
        // prev -> smaller envelope
        return prev[0] < curr[0] && prev[1] < curr[1];
    }

    private static int solveUsingTabulationSO(int[][] env) {
        int n = env.length;

        int[] currRow = new int[n + 1];
        int[] nextRow = new int[n + 1];

        for (int curr_index = n - 1; curr_index >= 0; curr_index--) {
            for (int prev_index = curr_index - 1; prev_index >= -1; prev_index--) {

                int include = 0;
                if (prev_index == -1 || check(env[curr_index], env[prev_index])) {
                    include = 1 + nextRow[curr_index + 1];
                }
                int exclude = nextRow[prev_index + 1];
                currRow[prev_index + 1] = Math.max(include, exclude);
            }
            // shifting
            nextRow = currRow.clone();
        }
        return nextRow[0];
    }

    public static int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes: if widths are the same, sort by height descending; otherwise,
        // by width ascending
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        return solveUsingTabulationSO(envelopes);
    }
}
