import java.util.*;

//here we do not need the Arraylist
public class CountSubsequenceWithSumK {
    public static int function(int arr[], int k, int index, int sum) {
        int n = arr.length;
        if (index == n) {
            if (sum == k) {
                return 1;
            } else {
                return 0;
            }

        }
        // include
        sum += arr[index];
        int left = function(arr, k, index + 1, sum);
        // exclude
        sum -= arr[index];
        int right = function(arr, k, index + 1, sum);
        return left + right;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        int ans = function(arr, 2, 0, 0);
        System.out.println(ans);
    }
}
