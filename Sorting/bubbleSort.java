public class bubbleSort {
    public static void Bubblesort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // for (int t = 0; t < arr.length - 1; t++) {
        // for (int j = 0; j < arr.length - t - 1; j++) {
        // if (arr[j] > arr[j + 1]) {
        // // swap
        // int temp = arr[j + 1];
        // arr[j + 1] = arr[j];
        // arr[j] = temp;
        // }
        // }
        // }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 3, 2 };
        Bubblesort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
/// arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
