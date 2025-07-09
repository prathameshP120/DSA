import java.util.HashMap;

public class CountSubArrayWithGivenXOR {
    public static int countSubArray(int a[],int k){
         int n=a.length;
          int cnt=0;
          //generating the subarrays

         for(int i=0;i<n;i++){
              for(int j=i;j<n;j++){
                 
                  int xorr=0;
                  for(int l=i;l<=j;l++){
                      xorr=xorr^a[l];
                  }
                  if(xorr==k){
                    cnt++;
                  }
              }

         }
         return cnt;
    }
    public static int Better(int nums[],int k){
        int cnt=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            int xorr=0;
            for(int j=i;j<n;j++){
                xorr=xorr^nums[j];
                if(xorr==k){
                cnt++;
            }
            }
            
        }
        return cnt;
    }
    public static int Optimal(int nums[],int k){
        //tc=o(n)
        //sc=o(n)  because of hash map s

        HashMap<Integer,Integer> hm=new HashMap<>();
         int n=nums.length;
        int xr=0;
        hm.put(xr,1);
        int cnt=0;

        
         for(int i=0;i<n;i++){
              xr=xr^nums[i];
              int x=xr^k;

              if(hm.containsKey(x)){
                cnt+=hm.get(x);
              }

              //put the xr into the hash map
              if(hm.containsKey(xr)){
                   hm.put(xr,hm.get(xr)+1);
              }else{
                hm.put(xr,1);

              }
         }

         return cnt;
    }
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;

        ///bruete force[Naive Approach]=>Tc=O(n^3)
        //int ans=countSubArray(a,k);
        //System.out.print(ans);
        //Better => Tc=O(n^2);
        // int ans=Better(a,k);
        // System.out.println(ans);

        //Optimal Approach
        int ans=Optimal(a,k);
        System.out.println(ans);


    }
}
