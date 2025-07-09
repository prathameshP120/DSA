import java.sql.Time;
import java.util.ArrayList;

public class CountInversion {
    public static void brueteForce(int nums[],int n){
          int cnt=0;
          for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                 if(nums[i]>nums[j]){
                    cnt++;
                 }
            }
          }
          System.out.println(cnt);
          
    }
    public static int  mergeSort(int arr[], int low, int high) {
      int cnt=0;
        //Base case
        if(low>=high){
            return cnt;
        }
        int mid=(low+high)/2;
        cnt+=mergeSort(arr, low, mid);
        cnt+=mergeSort(arr, mid+1,high);
        cnt+=merge(arr, low, mid, high);
        return cnt;

    }

    public static int merge(int arr[], int low, int mid, int high) {
           ArrayList<Integer> temp=new ArrayList<>();
            
           int left=low;
           int right=mid+1;

           //Modification 1
           int cnt=0;

           while(left<=mid && right<=high){
              if(arr[left]<=arr[right]){
                 temp.add(arr[left]);
                 left++;
              }else{
                ///here the left element is greater than the right 
                cnt+=mid-left+1;     //Modification 2
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

        return cnt;
      }


public static int numberOfInversions(int[] a, int n) {
//       Time Complexity: O(N*logN), where N = size of the given array.
// Reason: We are not changing the merge sort algorithm except by adding a variable to it. So, the time complexity is as same as the merge sort.

// Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.



        // Count the number of pairs:
        return mergeSort(a, 0, n - 1);
    }

    public static void main(String[] args) {
         //int[] a = {5, 4, 3, 2, 1};
         int a[]={5,3,2,1,4};
        int n = 5;
        //brueteForce
        //brueteForce(a, n);

        //Optimal Approach using the mergeSort

        int ans=numberOfInversions(a,  n);
        System.out.println(ans);

    }
}
