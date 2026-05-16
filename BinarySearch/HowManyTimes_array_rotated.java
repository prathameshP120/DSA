public class HowManyTimes_array_rotated {
    public static int BrueteForce(int arr[]){
        int ans=Integer.MAX_VALUE;
        int index=0;
        for(int i=0;i<arr.length;i++){
              if(arr[i]<ans){
                  ans=arr[i];
                  index=i;
              }
        }
        return index;
    }
    public static int Optimal(int arr[]){
         int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }
            //if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }

                // Eliminate left half:
                low = mid + 1;
            } else { //if right part is sorted:

                // keep the minimum:
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
         int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
         //using the bruete force approach :

        // int ans = BrueteForce(arr);
        // System.out.println(ans);

        //optimal approach :
        int ans=Optimal(arr);
        System.out.println(ans);
    }
}
