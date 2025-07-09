// this answer is correct but it gives wrong it
//here  whenever i encounter the closing bracket ,what i am looking for last openning encounter 
//means i just need to preserve the opoenning bracket  , so that why we use stack here(we looking for the something last )
 
import java.util.*;

public class ValidParenthesis {
    public static boolean isValidString(String str) {

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Openning
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);

            } else {
                // closing
                if (s.isEmpty()) {
                    return false;
                }
                if ((ch == ')' && s.peek() == '(') || (ch == '}' && s.peek() == '{')
                        || (ch == ']' && s.peek() == '[')) {

                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "({})";
        //TC=O(n),SC=O(n);
        System.out.println(isValidString(str));

    }
}
