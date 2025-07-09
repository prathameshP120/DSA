import java.util.HashMap;

public class LengthOfLongestSubArrayWithSumZero {
    public static int BruteForce(int nums[]){
        int longest=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==0){
                    longest=Math.max(longest,j-i+1);
                }
            }
        }
        return longest;
    }
    public static int Optimal(int nums[]){
        int maxi=0;
        int sum=0;
        int n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap();

        for(int i=0;i<n;i++){
             sum+=nums[i];
             //if we get the sum as zero 
             if(sum==0){
                maxi=i+1;
             }
             else{
                 if(hm.get(sum)!=null){
                     maxi=Math.max(maxi,i-hm.get(sum));
                 }else{
                    hm.put(sum,i);
                 }
             }

        }
    }
    public static void main(String[] args) {
        //
         int a[] = {9, -3, 3, -1, 6, -5};
         //Bruete force 
         //int ans=BruteForce(a);
         
         //Optimal 
         int ans=Optimal(a);
        
    }
    
}
