public class RepeatingAndMissingNumber {
    //Brute
    public static int[] BruetForce(int nums[]){
        //TC=O(n^2)
        //SC=O(1)
             int repeating=-1;
             int missing=-1;
             int n=nums.length;
           

             for(int i=1;i<=n;i++){
                  int cnt=0;
                  for(int j=0;j<n;j++){
                        if(nums[j]==i){
                            cnt++;
                        }
                  }
                  if(cnt==2){
                        repeating=i;
                   }else if(cnt==0){
                            missing=i;
                  }
                  if(repeating!=-1 && missing!=-1){
                      break;
                  }
             }

             return new int[]{repeating,missing};
    }
    public static void useHash(int a[]){
        //TC=O(n)
        //SC=O(n)

        int n=a.length;
        int hash[]=new int[n+1];
        for(int i=0;i<n;i++){
            hash[a[i]]++;
        }
        int reapting=-1;
        int missing=-1;
        for(int i=1;i<=n;i++){
             if(hash[i]==2){
                reapting=i;
             }else if(hash[i]==0){
                missing=i;
             }
        }
        System.out.println("repeating : "+reapting+ "And" +" Missing  :"+missing);

    }
    public static void main(String[] args) {
                 int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
                 //BrueteForce Approach
                int[] ans = BruetForce(a);
                for(int i=0;i<ans.length;i++){
                    System.out.print(" "+ans[i]);
                }

                //BrueteForce using HashMap
                useHash(a);

                //Optimal Approach=> Math => s-sn , s2-s2n
                optimal(a);
    }
}
