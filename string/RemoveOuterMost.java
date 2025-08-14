public class RemoveOuterMost {
    
}
class Solution {
    public String removeOuterParentheses(String s) {
        int start=0;
        int end=0;
        int count=0;
        StringBuilder sb=new StringBuilder();
      
        while(end<s.length()){
             if(s.charAt(end)=='('){
                 count++;
             }else if(s.charAt(end)==')'){
                count--;
             }
             if(count==0){
                  sb=sb.append(s.substring(start+1,end));
                  start=end+1;
             }
             end++;
        }
        return sb.toString();
    }
}

class Solution {
    public String removeOuterParentheses(String s) {
        //for storing the result 
        StringBuilder ans=new StringBuilder();
        Stack<Character> st=new Stack<>();
       int n=s.length();
        for(int i=0;i<n;i++){
              if(s.charAt(i)=='('){
                    if(st.size()>0){
                         ans.append(s.charAt(i));
                    }
                    st.push(s.charAt(i));
              }else{
                  st.pop();
                  if(st.size()>0){
                     ans.append(s.charAt(i));
                  }
              }

        }

        return ans.toString();

    }
}
//TC=O(n)
//SC=o(2n)