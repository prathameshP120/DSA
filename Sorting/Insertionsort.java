import java.util.*;

public class Insertionsort {
    public static void Sort(int arr[]) {
        // pick an element from unsorted part and put it at the right position in the
        // sorted part
        // consider first element of arr is in sorted part

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int curr = arr[i];
            int prev = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than curr, to one position ahead
             * of their current position
             */
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev = prev - 1;
            }
            arr[prev + 1] = curr;
        }

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 2, 3 };

        // Arrays.sort(arr, Collections.reverseOrder());
        // Sort(arr);
        printArr(arr);
    }

}
/// [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]