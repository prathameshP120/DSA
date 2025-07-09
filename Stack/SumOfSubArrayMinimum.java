public class SumOfSubArrayMinimum {
    public static int BruteForce(int arr[]){
           int sum=0;
           for(int i=0;i<arr.length;i++){
               int min=arr[i];
               for(int j=i;j<arr.length;j++){
                     min=Math.min(min, arr[j]);
                     sum=sum+min;
               }
           }
           return sum;
    }
    //For the optimal Approach 
    //1 4 6 7 3 7 8 1 
    //suppose your pointing to the element 3(that has an index_no=4)
    //first we analyze how many subArrays 3 is the minimum element 
    //for the all possible that include minim um element 3 is from the elements => 4 6 7 3 7 8 =>number of the subarray that can be form 3*4=12 and the sum=12*3=36
    //for we need to where is the nse and pse  {if we not get the nse then nse=n and if we not get the pse then pse=-1}
    



    

        public static void main(String[] args) {
         //int arr[]= {3,1,2,4 };   // output=17
         //Brute force TC=O(n^2)
         int arr[]={11,81,94,43,3};   //output=444
         int ans=BruteForce(arr);
         System.out.println(ans);
      }
}
