package Heap_PQ;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SequenceOfLengthKwithLargestSum {
    public static int[] findSequence(int nums[], int k) {
        // Min-Heap using PriorityQueue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] { nums[i], i });
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // HashSet to store indexes of selected elements
        HashSet<Integer> index = new HashSet<>();
        while (!pq.isEmpty()) {
            int ele[] = pq.poll();
            index.add(ele[1]);
        }

        int ans[] = new int[k];
        int p = 0;

        // ✅ Fix: Iterate using indices, not values
        for (int i = 0; i < nums.length; i++) {
            if (index.contains(i)) {
                ans[p] = nums[i];
                p++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 3, 3 };
        int k = 2;
        int ans[] = findSequence(nums, k);
        for (int e : ans) {
            System.out.println(e);
        }
    }
}
