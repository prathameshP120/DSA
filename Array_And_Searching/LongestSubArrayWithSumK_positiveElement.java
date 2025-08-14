// Example 1:
// Input Format: N = 3, k = 5, array[] = {2,3,5}
// Result: 2
// Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

// Example 2:
// Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
// Result: 3
// Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.
public class LongestSubArrayWithSumK_positiveElement {
    public static int bruteForce(int nums[],int k){
        int longest=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
             int sum=0;
             for(int j=i;j<n;j++){
                 sum+=nums[j];
                 if(sum==k){
                    longest=Math.max(longest, j-i+1);
                 }
             }    
        }
        return longest;
    }
    public static int sliiding_window(int arr[],int k){
        int sum=0;
        int left=0;
        int right=0;
        int longest=0;
        int n=arr.length;
        while(right<n){
             sum+=arr[right];
           while (left <= right && sum > k) {   //there could be the multiple elements that needs to be remove
            sum -=arr[left];
            left++;
           }
             if(sum==k){
                 longest=Math.max(longest,right-left+1);
             }
             right++;
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] arr={2,3,5,1,9};
        int k=10;
        //bruete force
        //int ans=bruteForce(arr,k);
        //System.out.println(ans);
        //optimal approach using sliding window
        int ans=sliiding_window(arr,k);
        System.out.println(ans);

    }
}
