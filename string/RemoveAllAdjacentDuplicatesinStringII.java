public class RemoveAllAdjacentDuplicatesinStringII {
    
    class Pair {
        char ch;
        int count;

        public Pair(char ch, int cnt) {
            this.ch = ch;
            this.count = cnt;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char currCh = s.charAt(i);
            if (!st.isEmpty() && currCh == st.peek().ch) {
                Pair prev = st.pop();
                st.push(new Pair(currCh, prev.count + 1));
            } else {
                st.push(new Pair(currCh, 1));
            }

            if (!st.isEmpty() && st.peek().count == k) {
                st.pop();
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            Pair temp = st.pop();
            for (int i = 0; i < temp.count; i++) {
                ans.append(temp.ch);
            }
        }

        return ans.reverse().toString();
    }

    // Optional main to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(sol.removeDuplicates(s, k));  // Output: "aa"
    }
}


