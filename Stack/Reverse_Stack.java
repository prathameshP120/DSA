import java.util.Stack;
//here we can simple use another stack and we get answer but it takes extra memory 
public class Reverse_Stack {

    public static Stack<Integer> pushAtTheBottom(Stack<Integer> st, int x) {
        if (st.empty()) {
            st.push(x);
        } else {
            int top = st.pop();
            pushAtTheBottom(st, x);
            st.push(top);
        }
        return st;
    }

    public static Stack<Integer> Reverse_Stack(Stack<Integer> st) {  //TC=O(n^2)
        if (st.empty()) {
            return st;
        }
        int top = st.pop();
        Reverse_Stack(st);
        pushAtTheBottom(st, top);

        return st;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);

        System.out.print(st);
        System.out.println();
        Reverse_Stack(st);
        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }
        System.out.println();

    }
}