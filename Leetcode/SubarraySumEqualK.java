public class SubarraySumEqualK {
          // this method not passed all the test cases
        public int subarraySum(int[] nums, int k) {
            int n=nums.length;
    
            int ls[]=new int[n];
            ls[0]=nums[0];
            for(int i=1;i<nums.length;i++){
                ls[i]=ls[i-1]+nums[i];
            }
            int cnt=0;
           for(int j=0;j<n;j++){
            int sum=0;
              for(int m=0;m<n;m++){   //firt time m=1 it does not run for nums[1]
                     if(j==0){
                        sum=ls[m];
                     }else{
                     sum=ls[m]-ls[j-1];
                     }
                     if(sum==k){
                        cnt++;
                     }
    
              }
           }
            
            return cnt;
        }
    }
