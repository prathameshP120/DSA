public class LeftRotateArraybyKplaces {
    public static void solveTemp(int arr[],int n,int k){
    k = k % n;
    int[] temp = new int[k];
    for (int i = 0; i < k; i++) {
      temp[i] = arr[i];
    }
    // suppose k=3 and n=5    5-3=2

    //start filling the the values to array from the i=0 to k-1(n-k); 
    for (int i = 0; i < n - k; i++) {
      arr[i] = arr[i + k];
    }

    for (int i = n - k; i < n; i++) {
      arr[i] = temp[i - n + k];
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
