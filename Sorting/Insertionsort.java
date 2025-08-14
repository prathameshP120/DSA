import java.util.*;

public class Insertionsort {  //pick the element and place it at right position
    public static void Sort(int arr[]) {
         int n=arr.length;
         for(int i=0;i<n;i++){
              int j=i;
              ///comparing the left element 
              while(j>0 && arr[j-1]>arr[j]){
                   int temp=arr[j];
                   arr[j]=arr[j-1];
                   arr[j-1]=temp;
                   j--;
              }
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
        Sort(arr);
        printArr(arr);
    }

}

/// [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]