// Given an array of integers, find the nearest smaller number for every element such that the smaller element is on the left side.
// Examples: 
// Input: arr = [1, 6, 2]
// Output: [-1, 1, 1,]
// Explanation: There is no number at the left of 1. Smaller number than 6 and 2 is 1.
// Input: arr = [1, 5, 0, 3, 4, 5]
// Output: [-1, 1, -1, 0, 3, 4]
// Explanation: Upto 3 it is easy to see the smaller numbers. But for 4 the smaller numbers are 1, 0 and 3. But among them 3 is closest. Similarly for 5 it is 4.

import java.util.Arrays;
import java.util.Stack;

public class SmallerElementOnLeft {
    public static int[] leftsmallerElement(int arr[]){
        int n=arr.length;
        int pse[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }else{
                pse[i]=arr[st.pop()];
            }
            st.push(i);
        }
        return pse;
    }
    public static void main(String args[]){
        int arr[]= {1, 5, 0, 3, 4, 5};
        int ans[]=leftsmallerElement(arr);
        System.out.println(Arrays.toString(ans));
        
    }
}
