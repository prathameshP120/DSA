public class SelectionSort {
    public static void Sort(int arr[]) {
        // outer loop
        int n = arr.length;

        // select minimum and swap 
        // 

        for (int i = 0; i < arr.length; i++) {


            int minpos = i;

          

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

        //Algorithm woking 
        //1] swap at index=0 and minimum index{0 to n-1}
        //2] swap at index=1 and minimum index{1 to n-1}
        //3] swap at index=2 and minimum index{2 to n-1}
        //4] swap at index=3 and minimum index{3 to n-1}
        //this still go on 
        //Time complexity  :
         //inner loop => n+(n-1)+(n-2)+(n-3)+(n-4)+...2+1=n*(n+1)/2=> n^2/2+ n/2 => O(n^2)


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
