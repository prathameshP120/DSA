import java.util.HashMap;
public class SubarraySumEqualK{
    public static void brueteForce(int nums[],int k){
        int cnt=0;
        
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    public static int optimal(int nums[],int k){
        //hash map to store sum and its frequency
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        int count=0;
        hm.put(0,1);
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(hm.containsKey(sum-k)){
                count+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum, 0)+1);
        }


    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        //brute force approach
        //brueteForce(arr,k);
        //Optimal approach 
        int ans=optimal(arr,k);
        System.out.println(ans);
    }
}
