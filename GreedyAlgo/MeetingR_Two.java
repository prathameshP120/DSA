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
        System.out.println("The number of required rooms are : " + ans);
    }

}
//Tmie Complexity :
//Sorting n intervals by start time → O(n log n)
// 2. Iterating through intervals
// for (int i = 0; i < n; i++) {
//     ...
// }
// Loop runs n times.
// Inside the loop:
// Heap operations (pq.add(), pq.remove(), pq.peek())
// Each operation takes O(log k) time, where k is the size of the heap (≤ n).
// 3. Total for heap operations
// For n intervals →
// Each interval causes at most one insertion and maybe one removal,
// so total heap operations = O(n log n).
//Total Time Complexity=O(n*logn) + O(n*logn)=O(n*logn)
