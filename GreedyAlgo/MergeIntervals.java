import java.util.*;

public class MergeIntervals {
   
    public static int[][] MergeIntervals(int intervals[][]) {
        List<int[]> res = new ArrayList<>();
        // sort the intervals
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int newInterval[] = intervals[0];
        res.add(newInterval);

        for (int i = 1; i < intervals.length; i++) {
            int interval[] = intervals[i];
            if (newInterval[1] > interval[0]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                // disjoint
                newInterval = interval;
                res.add(newInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int ans[][] = MergeIntervals(intervals);
        for (int[] interval : ans) {
            System.out.println(Arrays.toString(interval));
        }

    }
}

// Meeting room 1 (leetcode 252)

// public static boolean MeetingRoom1(int intervals[][]) {
// // sort the intervals on the basis of start
// Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
// List<int[]> res = new ArrayList<>(); // list of array to store the merge
// intervals

// int newInterval[] = intervals[0];

// res.add(newInterval);

// for (int i = 1; i < intervals.length; i++) {
// int[] interval = intervals[i];
// // Check if there's an overlap
// if (interval[0] < newInterval[1]) {
// return false; // Overlap found
// } else {
// // Update newInterval to the current interval
// newInterval = interval;
// res.add(interval);
// }
// }
// return true; // No overlap found

// }

// public static void main(String[] args) {
// int intervals[][] = { { 7, 10 }, { 2, 4 } };
// boolean ans = MeetingRoom1(intervals);
// System.out.println(ans);
// }
