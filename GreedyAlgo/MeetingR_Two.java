import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingR_Two {
    public static int Meeting_Room_two(int intervals[][]) {

        // sort on the basis of the start time
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int n = intervals.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                // int pq add only ending time
                pq.add(intervals[i][1]);
            }
            // for same room=> ( already add end time of interval <= start time of next
            // interval )
            // then poll it from the pq as they belong to same room
            if (pq.peek() <= intervals[i][0]) {
                pq.remove();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int intervals[][] = { { 0, 5 }, { 5, 10 }, { 15, 25 }, { 40, 60 }, { 50, 65 }, { 55, 75 } };
        int ans = Meeting_Room_two(intervals);
        System.out.println("The number of required rooms are" + ans);
    }

}
