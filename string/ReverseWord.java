// 151. Reverse Words in a String
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

// Example 1:

// Input: s = "the sky is blue"
// Output: "blue is sky the"
public class ReverseWord {
  
    public String reverseWords(String s) {
        String words[]=s.split(" ");
        
        StringBuilder sb=new StringBuilder();

        for(int i=(words.length-1);i>=0;i--){
              if(words[i].length()==0){
                  continue;
              }else{
                  sb.append(words[i]);
                  if(i!=0){
                        sb.append(" ");
                  }
                 
              }
        }
        return sb.toString().trim();

    }

    public String reverseWords(String s) {
        int si=s.length()-1;
        int ei=0;
        StringBuilder sb=new StringBuilder();
        while(si>=0){
             while(si>=0 && s.charAt(si)==' '){
                si--;
                continue;
             }
             if(si<0){
                break;
             }
             //you got the word
             ei=si;
             //you have to find start of the word 
             while(si>=0 && s.charAt(si)!=' '){
                   si--;
             }
             if(sb.length()==0){
                 sb.append(s.substring(si+1,ei+1));
             }else{
                sb.append(' ');
                 sb.append(s.substring(si+1,ei+1));

             }
        }
        
        return sb.toString();
    }
}