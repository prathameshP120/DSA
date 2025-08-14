public class bubbleSort {
    public static void Bubblesort(int arr[]) {
        int n = arr.length;
        for(int i=n-1;i>=1;i--){
            boolean didSwap=false;  //for the optimisation
            for(int j=0;j<=i-1;j++){
                 if(arr[j]>arr[j+1]){
                      int temp=arr[j];
                      arr[j]=arr[j+1];
                      arr[j+1]=temp;
                      didSwap=true;
                 }
            }
            if(!didSwap){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 3, 2 };
        Bubblesort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
/// arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
