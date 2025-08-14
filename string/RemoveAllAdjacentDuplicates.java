
// You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

// We repeatedly make duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

// Example 1:

// Input: s = "abbaca"
// Output: "ca"
// Explanation: 
// For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

public class RemoveAllAdjacentDuplicates {
    public static String ans(String s){
          int idx=0;
          int n=s.length();
          StringBuilder res=new StringBuilder();

          while(idx<n){
              //checking the alreasy add character in ans and processin charater is not the same 
              if(res.length()>0 && res.charAt(res.length()-1)==s.charAt(idx)){
                   res.deleteCharAt(res.length()-1);

              }else{
                  res.append(s.charAt(idx));
              }
              idx++;
          }
          return res.toString();
    }
      
      public static void main(String[] args) {
        String s="abbaca";
        System.out.println(ans(s));
      }
}
