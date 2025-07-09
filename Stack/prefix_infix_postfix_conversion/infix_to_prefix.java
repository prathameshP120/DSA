package prefix_infix_postfix_conversion;

import java.util.Stack;

public class infix_to_prefix {
    public static int prec(Character c){
         switch(c){
            case '+':
            case '-':
            return 1;
            case '*':
            case '/':
            return 2;
            case '^':
            return 3;
         
         }
         return -1;

    }
    public static String infixTopostfix(String exp){
        String res=new String("");
        Stack<Character> st=new Stack<>();

        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                 res+=c;
            }
            //If the Scanned Character is an '(',
            //push it to the stack
            else if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while(!st.empty() && st.peek()!='('){
                    res+=st.pop();
                }
                st.pop();
            }
            else{  //an operator is encountered
               while (!st.isEmpty() && prec(c)<=prec(st.peek())) {
                res+=st.pop();
               }
               st.push(c);
            }

        }
        // pop all the operators from the stack
    while (!st.isEmpty()) {
      if (st.peek() == '(')
        return "Invalid Expression";
      res += st.pop();
    }
    return res;
}
    public static void main(String[] args) {
        //String infix="(p+q)*(m-n)";
        String infix="a+b*(c^d-e)^(f+g*h)-i";
        String revInfix=new StringBuilder(infix).reverse().toString();

        String postFix=infixTopostfix(revInfix);
        System.out.println(postFix);
    }
}