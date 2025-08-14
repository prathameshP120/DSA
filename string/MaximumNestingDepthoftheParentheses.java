// Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

 

// Example 1:

// Input: s = "(1+(2*3)+((8)/4))+1"

// Output: 3





public class MaximumNestingDepthoftheParentheses {
    
    public static  int maxDepth(String s) {
        //we count the nesting by using maxi variable 
        //whenever we encounter the ( bracket we increament the counter by 1 and whenerver 
        //we encounter the ) barcket we decreament the counter 
        int count=0;
        int maxi=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
                if(count>maxi){
                    maxi=count;
                }
            }else if(s.charAt(i)==')'){
                count--;
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        String s="(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }
}

