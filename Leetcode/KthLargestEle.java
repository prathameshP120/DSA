import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestEle {
    public static int KthLargestEle(int nums[], int k) {
        // this give me eror PriorityQueue<Integer> maxheap = new
        // PriorityQueue<>(Collection.reverseOrder);
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            maxheap.add(nums[i]);

        }
        for (int i = 0; i < k - 1; i++) {
            maxheap.poll();
        }
        return maxheap.peek();
    }

    public static void main(String[] args) {
        int nums[] = { 3, 2, 4, 6, 1, 9 };
        int k = 3;

        int ans = KthLargestEle(nums, k);
        System.out.println(ans);
    }

}
