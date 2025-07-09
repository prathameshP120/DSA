public class MaxSubArraySum_kadnes {
    public static void BruteForce(int nums[]){
        int sum=0;
        int n=nums.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sum=0;
                 for(int k=i;k<=j;k++){
                     sum+=nums[k];
                 }
                 maxi=Math.max(maxi, sum);
            }
        }
        System.out.println(maxi);
    }

    //Better 
    public static void Better(int nums[]){
        int sum=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                maxi=Math.max(maxi, sum);
            }
            
        }
        System.out.println(maxi);
    }

    public static void kadanes(int numbers[]) {
        //TC=O(n)
        //Sc=O(1)
        int ms = Integer.MIN_VALUE;
        int sum = 0;
        int start=0;
        int ansStart=-1;
        int ansEnd=-1;
        for (int i = 0; i < numbers.length; i++) {
            if(sum==0){
                start=i;
            }
            sum = sum + numbers[i];
            if (sum < 0) {
                sum = 0;

            }
            if(sum>ms){
                ms=sum;
                ansStart=start;
                ansEnd=i;
            }
        }
        System.out.println("max sum is" + ms);
        for(int i=ansStart;i<=ansEnd;i++){
            System.out.print(" "+numbers[i]);
        }

    }

    public static void main(String[] args) {
        int numbers[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        //Brute Force 
        //BruteForce(numbers); //=> TC=O(n^3)
        //Better
       // Better(numbers);=>Tc=o(n^2)
       kadanes(numbers);
  
    }
}
