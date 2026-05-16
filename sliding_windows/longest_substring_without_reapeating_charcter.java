import java.sql.Time;
import java.util.Arrays;
import java.util.HashSet;

public class longest_substring_without_reapeating_charcter {
    public static int LOLongestSubsUsingBruteForce(String s) {
        int n=s.length();
        int maxlength=0;
        for(int i=0;i<n;i++){
              HashSet<Character> set=new HashSet<>();
              for(int j=i;j<n;j++){
                   if(set.contains(s.charAt(j))){
                        maxlength=Math.max(maxlength,j-i);
                        break;
                   }
                 set.add(s.charAt(i));
              }
              
        }

        return maxlength;

    }

    static int lengthOfLongestSubstring(String s) {

        // Array to store the last index
        // where each character occurred
        int[] hash = new int[256];

        // Initialize all elements
        // of the array to -1
        Arrays.fill(hash, -1);

        // Get the length of
        // the input string
        int n = s.length();

        // Pointers to keep track
        // of the current substring
        int l = 0, r = 0;

        // Variable to store the maximum
        // length of substring without
        // repeating characters
        int maxLen = 0;

        // Loop until the right pointer
        // reaches the end of the string
        while (r < n) {
            // If the current character
            // has been seen before
            if (hash[s.charAt(r)] != -1) {
                // If its last occurrence is
                // within the current substring
                if (hash[s.charAt(r)] >= l) {
                    // Move the left pointer to the
                    // position after the last occurrence
                    // of the current character
                    l = hash[s.charAt(r)] + 1;
                }
            }

            // Calculate the length
            // of the current substring
            int len = r - l + 1;

            // Update the maximum
            // length if needed
            maxLen = Math.max(len, maxLen);

            // Update the last occurrence
            // index of the current character
            hash[s.charAt(r)] = r;

            // Move the right pointer
            // to the next position
            r++;
        }
        // Return the maximum length of
        // substring without repeating characters
        return maxLen;
        // Time Complexity: O(N) where N is the length of the input string as we iterate
        // through the
        // string once with two pointers (l and r) and perform constant time operations
        // inside the loop.
        // Space Complexity : O(256) as a fixed array of size 256 to cover all ASCII
        // characters is used. This uses constant space and is not proportional to the
        // input values.
    }
    public static int Better(String s){
          int n=s.length();
          int l=0;
          int r=0;
          int maxlen=0;
          HashSet<Character> set=new HashSet<>(); 
          while(r<n){
              while(l<r && set.contains(s.charAt(r))){
                   set.remove(s.charAt(l));
                   l++;

              }
              set.add(s.charAt(r));
              maxlen=Math.max(maxlen,r-l+1);
              r++;
          }
          return maxlen;
     //Time Complexity: O( 2*N ) (sometimes left and right both have to travel complete array)
     //Space Complexity: O(N) where N is the size of HashSet taken for storing the elements

    }
    

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Input String: " + s);
        // Using Bruete force
        //int ans = LOLongestSubsUsingBruteForce(s);
        //Better Approach :
        int ans=Better(s);
        System.out.println();
        // Using Optimal Solution

        System.out.println(ans);

    }
}
