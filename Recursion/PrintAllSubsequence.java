import java.util.ArrayList;

public interface PrintAllSubsequence {
    public static void function(int arr[], ArrayList<Integer> list, int index) {
        int n = arr.length;
        if (index >= n) {
            System.out.println(list);
            return;
        }
        list.add(arr[index]);
        function(arr, list, index + 1); // include
        list.remove(list.size() - 1);
        function(arr, list, index + 1); // exclude

    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 2 };
        ArrayList<Integer> list = new ArrayList<>();
        function(arr, list, 0);
    }
}
