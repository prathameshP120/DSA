public class FirstOccurance {
    public static int firstOccurance(int arr[], int key, int i) {
        if (i == arr.length - 1) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }

        return firstOccurance(arr, key, i + 1);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 5, 6, 7, 8, 4, 7, 8, 7, 3, 7 };
        int key = 4;
        System.out.println(firstOccurance(arr, key, 0));
    }
}
