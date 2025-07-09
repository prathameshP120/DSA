public class BackTracingOnArray {

    public static void changeArray(int arr[], int i, int value) {
        if (i == arr.length) {
            printArray(arr);
            return;
        }
        arr[i] = value;
        changeArray(arr, i + 1, value + 1);
        // bactraking array
        arr[i] = arr[i] - 2;

    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArray(arr, 0, 1);
        // printing the backtrack array
        printArray(arr);
    }

    /*
     * public static void changeArray(int arr[], int i, int val) {
     * if (i == arr.length) {
     * printArray(arr);
     * return;
     * }
     * // Recursion
     * arr[i] = val;
     * changeArray(arr, i + 1, val + 1);
     * 
     * // Backtracing
     * arr[i] = arr[i] - 2;
     * 
     * }
     * 
     * public static void printArray(int arr[]) {
     * for (int i = 0; i < arr.length; i++) {
     * System.out.print(arr[i] + " ");
     * }
     * System.out.println();
     * }
     * 
     * public static void main(String[] args) {
     * int arr[] = new int[5];
     * changeArray(arr, 0, 1);
     * printArray(arr);
     * }
     * 
     * 
     */

}
