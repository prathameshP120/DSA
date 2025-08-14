public class ReverseWord {
    
}

class Solution {
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
}

class Solution {
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