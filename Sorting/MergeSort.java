import java.util.ArrayList;

public class MergeSort {

    public static void mergeSort(int arr[], int low, int high) {
        //Base case
        if(low>=high){
            return;
        }
        int mid=(low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1,high);
        merge(arr, low, mid, high);

    }

    public static void merge(int arr[], int low, int mid, int high) {
           ArrayList<Integer> temp=new ArrayList<>();
            
           int left=low;
           int right=mid+1;

           while(left<=mid && right<=high){
              if(arr[left]<=arr[right]){
                 temp.add(arr[left]);
                 left++;
              }else{
                 temp.add(arr[right]);
                 right++;
              }
           }
           
           //handling the remaining element of left part 
           while(left<=mid){
                temp.add(arr[left]);
                 left++;
           }
            //handling the remaining element of right part 
           while(right<=high){
                temp.add(arr[right]);
                 right++;
           }

           ///copying the temp array into the original array
          for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 3, 6, 2, 7, 8, 9, 1 };
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);

    }
}
