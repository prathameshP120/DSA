import java.util.Stack;

class PushAtBottom {
    /*
     * public static Stack<Integer> PushAtTheBottom(Stack<Integer> st, int x) {
     * 
     * Stack<Integer> s = new Stack<>();
     * while (!st.empty()) {
     * s.push(st.pop());
     * 
     * }
     * st.push(x);
     * while (!s.empty()) {
     * st.push(s.pop());
     * 
     * }
     * 
     * return st;
     * }
     * 
     * public static void main(String[] args) {
     * Stack<Integer> st = new Stack<>();
     * st.push(1);
     * st.push(2);
     * st.push(3);
     * 
     * System.out.println(PushAtTheBottom(st, 4));
     * 
     * }
     * }
     */

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

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);

        System.out.print(st);
        System.out.println();
        System.out.println(pushAtTheBottom(st, 4));

        while (!st.empty()) {
            System.out.print(st.pop());
        }
    }
}
//TC=O(n)  , SC=O(n)(recursive stack space )