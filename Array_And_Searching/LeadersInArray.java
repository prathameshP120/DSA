// You are given an array arr of positive integers.
//Your task is to find all the leaders in the array. 
//An element is considered a leader if it is greater than or equal to all elements to its right. 
//The rightmost element is always a leader.
 
import java.util.ArrayList;

public class LeadersInArray {
    public static void BruteForce(int arr[]){
        ArrayList<Integer> ans=new ArrayList<>();
    
        for(int i=0;i<arr.length;i++){
            boolean isleader=true;  //we consider that the ith element will be our leader 
            for(int j=i+1;j<arr.length;j++){
                  if(arr[j]>arr[i]){
                    isleader=false;
                    break;
                  }

            }
            if(isleader){
                 ans.add(arr[i]);
            }
        }
        for(int i=0;i<ans.size();i++){
               System.out.println(ans.get(i));
        }
    }
    public static void optimal(int arr[]){
        int maxi=Integer.MIN_VALUE;
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
             if(arr[i]>maxi){
                ans.add(arr[i]);
             }
             maxi=Math.max(arr[i],maxi);
        }
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
    public static void main(String[] args) {
        int arr []= {16, 17, 4, 3, 5, 2};
        //BruteForce 
       // BruteForce(arr);
        //Optimal 
        //keep track of maximum element from right part \
        optimal(arr); // TC=O(n)

    }
}
