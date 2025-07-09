public class SelectionSort {
    public static void Sort(int arr[]) {
        // outer loop
        int n = arr.length;

        // select the minimum elelment(from the unsorted array)and put it at the begging
        // outer loop

        for (int i = 0; i < arr.length; i++) {

            // i=0 arr[0]=5 consider it as at the minimum position

            int minpos = i;

            // now track the minpos from //4,1,2,3

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minpos] > arr[j]) {
                    minpos = j;
                }
            }
            // swap i(sorted part) and minpos
            int temp = arr[minpos];
            arr[minpos] = arr[i];
            arr[i] = temp;
        }

    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 2, 3 };
        Sort(arr);
        printArr(arr);
    }
}
