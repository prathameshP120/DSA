import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public static List<List<Integer>> three_sum(List<Integer> list, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = list.size();

        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums); // Sort the array first

        for (int i = 0; i < n - 2; i++) {
            int lp = i + 1;
            int rp = n - 1;
            while (lp < rp) {
                //
                if ((nums[i] + nums[lp] + nums[rp]) == target) {
                    res.add(Arrays.asList(nums[i], nums[lp], nums[rp]));
                    lp++;
                    rp--;

                }
                if ((nums[i] + nums[lp] + nums[rp]) < target) {
                    lp++;
                } else {
                    rp--;
                }
            }
        }
        return new ArrayList<>(res);

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int target = 0;
        list.add(-1);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(-1);
        list.add(-4);
        List<List<Integer>> ans = three_sum(list, target);
        System.out.println(ans);
    }
}
