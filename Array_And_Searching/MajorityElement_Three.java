// Problem Statement: Given an array of N integers. 
// Find the elements that appear more than N/3 times in the array. 
// If no such element exists, return an empty vector.
// Example 1:
// Input Format: N = 5, array[] = {1,2,2,3,2}
// Result: 2
// Explanation: Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.

// Example 2:
// Input Format:  N = 6, array[] = {11,33,33,11,33,11}
// Result: 11 33

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement_Three{
    public static void BrueteForce(int arr[]){
        int n=arr.length;

        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<n;i++){

            if(ans.size()==0 || ans.get(0)!=arr[i]){
                  int cnt=0;
                  for(int j=0;j<n;j++){
                       if(arr[i]==arr[j]){
                          cnt++;
                       }
                  }

               if(cnt>n/3){
                ans.add(arr[i]);
               }
            }
            if(ans.size()==2){
                 break;
            }
        }
        //print the answer
        for(int ele:ans){
                System.out.print(ele+" ");
        }
    }
    public static void Better(int arr[]){
        ArrayList<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=arr.length;
        int mini=(int)n/3+1;
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);

            if(hm.get(arr[i])==mini){
                ans.add(arr[i]);
            }

            if(ans.size()==2){
                break;
            }
        }
        for(int ele:ans){
              System.out.print(ele+" ");
        }
// Time Complexity: O(N*logN), where N = size of the given array.
// Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN).
// If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).

// Space Complexity: O(N) as we are using a map data structure. We are also using a list that stores a maximum of 2 elements. That space used is so small that it can be considered constant.
}
public static void majorityElementMooresVoting(int []v) {
        int n = v.length; //size of the array

        int cnt1 = 0, cnt2 = 0; // counts
        int el1 = Integer.MIN_VALUE; // element 1
        int el2 = Integer.MIN_VALUE; // element 2

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != v[i]) {
                cnt1 = 1;
                el1 = v[i];
            } else if (cnt2 == 0 && el1 != v[i]) {
                cnt2 = 1;
                el2 = v[i];
            } else if (v[i] == el1) cnt1++;
            else if (v[i] == el2) cnt2++;
            else {
                cnt1--; cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el1) cnt1++;
            if (v[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);

        for(int ele:ls){
            System.out.print(ele+" ");
        }
        // Uncomment the following line
        // if it is told to sort the answer array:
        //Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

    }
    public static void main(String[] args) {
       int[] arr = {11, 33, 33, 11, 33, 11};
       //brute force approach
       //BrueteForce(arr);
       //Better-- using the HashMap
       //Better(arr);
       //Optimal=> moores voting algorithm 
       majorityElementMooresVoting(arr);
       
    }
}
