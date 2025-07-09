public class LeftRotateByAnArray {
    public static void solve(int arr[],int n){
        int temp=arr[0];
        for(int i=1;i<n;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=temp;

        // printing the answer 
        for(int ele:arr){
            System.out.println(ele);
        }
    }
    public static void main(String[] args) {
        int n=5;
  
       int arr[]= {1,2,3,4,5};
      solve(arr, n);

    }
}
