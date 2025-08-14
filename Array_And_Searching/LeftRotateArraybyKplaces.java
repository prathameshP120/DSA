import java.sql.Time;

public class LeftRotateArraybyKplaces {
    public static void solve(int arr[],int n,int k){
     //after rotating the array n times it comes to original array

    k = k % n; 
    //As if k=2 n=7 => k%n => 2 because : 0 (quotient) with remainder 2
    //As k=9 n=7 => k%n => 2 

    int[] temp = new int[k];
    for (int i = 0; i < k; i++) {
      temp[i] = arr[i];
    }
    // suppose k=3 and n=5    5-3=2

    //start filling the the values to array from the i=0 to k-1(n-k); 
    for (int i = 0; i < n - k; i++) {
      arr[i] = arr[i + k];
    }
   int j=0;
    for (int i = n - k; i < n; i++) {
      arr[i] = temp[j];
      j++;
    }
    ///print the result 
    for(int ele:arr){
        System.out.println(ele);
    }

    }
    public static void reverse(int arr[],int first,int last){

      while(first<last){
         int temp=arr[first];
         arr[first]=arr[last];
         arr[last]=temp;
         first++;
         last--;
      }
        
    }
    public static void solveReversal(int arr[],int n, int k){
        k=k%n;
        if(k==0){
          return;
        }
        reverse(arr,0,n-1);
        reverse(arr, 0, n-k-1); 
        reverse(arr, n-k, n-1);

        //Printing the result 
        for(int i=0;i<n;i++){
          System.out.println(arr[i]);
        }
 // Time Complexity: O(n)
 // Each call to reverse() takes O(m) time, where m is the number of elements in that segment.

 // In total, the combined work is:

 // First reverse: O(n)

 // Second reverse: O(n - k)

 // Third reverse: O(k)
    }
    public static void main(String[] args) {
          int n = 7;
          int[] arr = {1,2,3,4,5,6,7};
          int k=2;
          //Approach1 => Tc=O(n) and SC=O(k)
          //solve(arr,n,k);
          //Approach2 => Reversal technique;
          solveReversal(arr,n,k);

    }
}
