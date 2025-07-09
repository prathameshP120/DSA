import java.util.ArrayList;

public class PrintAnyOneSubsequenceWithSumK {
    public static boolean function(int arr[], int k, int index, ArrayList<Integer> list, int sum) {
        int n = arr.length;
        if (index == n) {
            if (sum == k) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        // include
        list.add(arr[index]);
        sum += arr[index];
        if (function(arr, k, index + 1, list, sum) == true) {
            return true;
        }
        // exclude
        list.remove(list.size() - 1);
        sum -= arr[index];
        if (function(arr, k, index + 1, list, sum) == true) {
            return true;
        } else {
            return false;

        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        ArrayList<Integer> list = new ArrayList<>();
        boolean ans = function(arr, 2, 0, list, 0);
        System.out.println(ans);
    }
}
