// 75. Sort Colors
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]


import java.util.ArrayList;
public class SortColor {
    //optimal solution logic 
    //[0...low-1]=>      0 extreme left 
    //[left....mid-1]=>  1
    //[mid.....high]=>   any number 0/1/2
    //[high+1..n-1] =>   2 extreme right 
    //now as we see we have to sort the array between the mid to high{because this part is not sorted }
    //initially low and mid =0 and the high=n-1
    //we have to handle the cases like a[mid]==0  or 1 or 2
    public static void Optimal(ArrayList<Integer> arr, int n) {
        int low = 0, mid = 0, high = n - 1; // 3 pointers

        while (mid <= high) {
            if (arr.get(mid) == 0) {
                // swapping arr[low] and arr[mid]
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);

                low++;
                mid++;

            } else if (arr.get(mid) == 1) {   ///means it is aready sorted just move mid 
                mid++;

            } else {
                // swapping arr[mid] and arr[high]
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);

                high--;
            }
        }
        

        //print the result 
        for(int ele:arr){
            System.out.print(ele + " ");
        }
    }
   



    public static void main(String[] args) {
        int nums[]={2,0,2,1,1,0};
        ArrayList<Integer> list=new ArrayList<>();
        for(int ele:nums){
            list.add(ele);
        }
        //BruteForce=> sorting algorithm 
        //Better=> just count the number of of zeros , ones and twos
        //Optimal soultion => TC=O(n) , SC=O(1)
        Optimal(list, nums.length);

    }
    
}
