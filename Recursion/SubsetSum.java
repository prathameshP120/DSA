import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SubsetSum {
    public static void function(int arr[], ArrayList<Integer> ans, int index, int sum) {
        int n = arr.length;
        if (index == n) {
            ans.add(sum);
            return;
        }
        // inlude case(means pick that index)
        function(arr, ans, index + 1, sum + arr[index]);
        // exclude case(not pick that index)
        function(arr, ans, index + 1, sum);

    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2 };
        ArrayList<Integer> subsetSum = new ArrayList<>();
        function(arr, subsetSum, 0, 0);
        Collections.sort(subsetSum);
        System.out.println(subsetSum);
    }
}