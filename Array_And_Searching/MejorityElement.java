// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times.
//You may assume that the majority element always exists in the array.

// Example 1:
// Input: nums = [3,2,3]
// Output: 3

// Example 2:
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2

import java.util.HashMap;
import java.util.Map;

public class MejorityElement {
    //Brute force Approach
    public static int BruteForce(int []v) {
        //size of the given array:
        int n = v.length;

        for (int i = 0; i < n; i++) {
            //selected element is v[i]
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // counting the frequency of v[i]
                if (v[j] == v[i]) {
                    cnt++;
                }
            }

            // check if frquency is greater than n/2:
            if (cnt > (n / 2))
                return v[i];
        }

        return -1;
    }
 //Better 
 
public static int Better(int []v) {
        //size of the given array:
        int n = v.length;

        //declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();

        //storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
             mpp.put(v[i], mpp.getOrDefault(v[i], 0)+1);
        }

        //searching for the majority element:
        // for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
        //     if (it.getValue() > (n / 2)) {
        //         return it.getKey();
        //     }
        // }
        for(int i=0;i<n;i++){
            if(mpp.get(v[i])>n/2){
                  return v[i];
            }
        }
        return -1;
        //Time Complexity: O(N), where N = size of the given array.
        //Space Complexity: O(N) as we are using a map data structure.
    }
    ///Optimal=> Moore’s Voting Algorithm: TC=O(n)+O(n)
    public static int optimal(int v[]){
        int cnt=0;
        int ele=0;
        for(int i=0;i<v.length;i++){
            if(cnt==0){
                cnt=1;
                ele=v[i];

            }else if(ele==v[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        int cnt1=0;
        for(int i=0;i<v.length;i++){
            if(ele==v[i]){
                cnt1++;
            }
        }
        if(cnt1>v.length/2){
            return ele;
        }
        return -1;

    }

    public static void main(String args[]) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        
        int ans=Better(arr);
        //int ans = optimal(arr);
        System.out.println(ans);
    
}
}