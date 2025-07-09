import java.util.ArrayList;

public class PrintAllSubsequenceWhoseSumK {
    public static void function(int arr[], int k, int index, ArrayList<Integer> list, int sum) {
        int n = arr.length;
        if (index == n) {
            if (sum == k) {
                System.out.println(list);
            }
            return;
        }
        // include
        list.add(arr[index]);
        sum += arr[index];
        function(arr, k, index + 1, list, sum);
        // exclude
        list.remove(list.size() - 1);
        sum -= arr[index];
        function(arr, k, index + 1, list, sum);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        ArrayList<Integer> list = new ArrayList<>();
        function(arr, 2, 0, list, 0);
    }
}
