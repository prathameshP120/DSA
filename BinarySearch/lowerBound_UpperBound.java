// Lower Bound:   smallest index such that arr[index]>=x 

// The smallest index where the element is greater than or equal to the given value(x).
// Upper Bound :
// The smallest index where the element is strictly greater than the given value.

public class lowerBound_UpperBound {
    public static int lowerBound(int arr[],int x){
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }

        }
        return ans;
    }

    public static int upperBound(int arr[],int x){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start);
            if(arr[mid]>x){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public static void main(String args[]){

        int arr[]={2, 3, 7, 10, 11, 11, 25};
        // int target=9;
        // int ans=lowerBound(arr,target);
        // System.out.println(ans);

        //UpperBound
        int target=11;
        int ans=upperBound(arr,target);
        System.out.println(ans);
    }
}
