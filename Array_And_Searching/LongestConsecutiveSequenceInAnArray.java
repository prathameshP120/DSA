import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceInAnArray {
    public static boolean linearSearch(int target,int a[]){
        for(int i=0;i<a.length;i++){
            if(target==a[i]){
                return true;
            }

        }
        return false;
    }
    public static int BruteForce(int a[]){
        int longest=1;
        int n=a.length;
        for(int i=0;i<n;i++){
            int x=a[i];
            int cnt=1;
            while(linearSearch(x+1,a)==true){
                 cnt+=1;
                 x+=1;
            }
            longest=Math.max(longest, cnt);

        }
        return longest;
    }
    public static int better(int a[]){
        int cnt=0;
        int lastSmall=Integer.MIN_VALUE;
        int longest=1;
        int n=a.length;
        for(int i=0;i<n;i++){
            if((a[i]-1)==lastSmall){
                cnt+=1;
                lastSmall=a[i];
            }else if(a[i]!=lastSmall){
                 cnt=1;
                 lastSmall=a[i];
            }
            longest=Math.max(longest, cnt);
        }
        return longest;
    }
    public static int optimal(int a[]){
//         Time Complexity: O(N) + O(2*N) ~ O(3*N), where N = size of the array.
// Reason: O(N) for putting all the elements into the set data structure. After that for every starting element, we are finding the consecutive elements. Though we are using nested loops, the set will be traversed at most twice in the worst case. So, the time complexity is O(2*N) instead of O(N2).

// Space Complexity: O(N), as we are using the set data structure to solve this problem.
         
        int n=a.length;
        if(n==0){
            return 0;
        }


        Set<Integer> set=new HashSet<>();
        
        //putting all the element into the set 
        for(int ele:a){
            set.add(ele);
        }
       int longest=1;
       for(int ele:set){
           //if the element is the starting point
           if(!set.contains(ele-1)){
               int cnt=1;
               while(set.contains(ele+1)){
                   cnt+=1;
                   ele+=1;
               }
               longest=Math.max(cnt, longest);
           }
          
       }
       return longest;

    }
    public static void main(String[] args) {
          int[] a = {100, 200,1, 2,2, 3,3, 4};
           //BruetForce TC=O(n^2)
           //int ans=BruteForce(a);
           //System.out.println(ans);
           //Better 
           //int ans=better(a);
           //System.out.println(ans);

           //Optimal
           int ans=better(a);
           System.out.println(ans);


    }
    
}
