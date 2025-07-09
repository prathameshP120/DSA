// Recursion
// public class NinjaTraining {
// public static int recursion(int day, int last, int points[][]) {
// int numberOfTask = points[0].length;

// if (day == 0) {
// int max = 0;
// for (int task = 0; task < numberOfTask; task++) {
// if (task != last) {
// max = Math.max(max, points[day][task]); // Fix indexing here
// }
// }
// return max; // Add return statement for base case
// }

// int maxi = 0;
// for (int task = 0; task < numberOfTask; task++) {
// if (task != last) { // Ensure the same task is not picked
// int activity = points[day][task] + recursion(day - 1, task, points);
// maxi = Math.max(activity, maxi);
// }
// }
// return maxi;
// }

// public static void main(String[] args) {
// int[][] points = {
// { 10, 40, 70 },
// { 20, 50, 80 },
// { 30, 60, 90 }
// };

// int n = points.length; // Get the number of days
// int ans = recursion(n - 1, 3, points); // Pass '3' to represent no task
// chosen initially
// System.out.println(ans);
// }
// }

// Memoization
// import java.util.*;

// public class NinjaTraining {
// // Recursive function to calculate the maximum points for the ninja training
// static int f(int day, int last, int[][] points, int[][] dp) {
// // If the result is already calculated, return it
// if (dp[day][last] != -1)
// return dp[day][last];

// // Base case: When it's the first day (day == 0)
// if (day == 0) {
// int maxi = 0;
// for (int i = 0; i <= 2; i++) {
// if (i != last)
// maxi = Math.max(maxi, points[0][i]);
// }
// return dp[day][last] = maxi; // Store and return the result
// }

// int maxi = 0;
// // Loop through the three activities on the current day
// for (int i = 0; i <= 2; i++) {
// if (i != last) {
// // Calculate the points for the current activity and recursively
// // calculate the maximum points for the previous day
// int activity = points[day][i] + f(day - 1, i, points, dp);
// maxi = Math.max(maxi, activity); // Update the maximum points
// }
// }

// return dp[day][last] = maxi; // Store and return the result
// }

// // Function to find the maximum points for ninja training
// static int ninjaTraining(int n, int[][] points) {
// // Initialize a memoization table with -1 values
// int dp[][] = new int[n][4];
// for (int[] row : dp)
// Arrays.fill(row, -1);

// // Start the recursive calculation from the last day (n - 1) with the last
// // activity (3)
// return f(n - 1, 3, points, dp);
// }

// public static void main(String args[]) {
// // Define the points for each activity on each day
// int[][] points = { { 10, 40, 70 },
// { 20, 50, 80 },
// { 30, 60, 90 } };

// int n = points.length; // Get the number of days
// System.out.println(ninjaTraining(n, points)); // Calculate and print the
// maximum points
// }
// }
public class NinjaTraining {
    public static int tabulation(int n, int points[][]) {
        int dp[][] = new int[n][4]; // Fix the size to n x 4

        // Base case
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][1], points[0][0]);
        dp[0][3] = Math.max(points[0][1], Math.max(points[0][2], points[0][0]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) { // Only 3 tasks (0,1,2)
                    if (task != last) {
                        int pts = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], pts);
                    }
                }
            }
        }
        return dp[n - 1][3]; // Fix the return value
    }

    static int spaceOptimiazation(int n, int[][] points) {
        // Initialize an array 'prev' to store the maximum points for the previous day
        int prev[] = new int[4];

        // Initialize the first day's maximum points based on the available choices
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day starting from the second day
        for (int day = 1; day < n; day++) {
            // Initialize an array 'temp' to store the maximum points for the current day
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum
                        // points from the previous day
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            // Update 'prev' to store the maximum points for the current day
            prev = temp;
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return prev[3];
    }

    public static void main(String args[]) {
        int[][] points = {
                { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 }
        };
        int n = points.length;
        System.out.println(tabulation(n, points));
    }
}