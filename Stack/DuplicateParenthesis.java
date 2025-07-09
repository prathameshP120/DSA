import java.util.*;

public class DuplicateParenthesis {
    public static boolean isDuplicate(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                int cnt = 0;
                while (st.peek() != '(') {
                    st.pop();
                    cnt++;
                }
                st.pop(); // Pop the '(' character

                // If cnt < 1, it means there was nothing between the parentheses
                if (cnt < 1) {
                    return true;
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(isDuplicate(str)); // Should print true

        str = "(a+(b)/c)";
        System.out.println(isDuplicate(str)); // Should print false

        str = "(a+b)";
        System.out.println(isDuplicate(str)); // Should print false
    }
}
