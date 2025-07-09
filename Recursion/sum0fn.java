public class sum0fn {
    public static void function(int n, int sum) {
        if (n < 1) {
            System.out.println(sum);
            return;
        }
        function(n - 1, sum + n);
    }

    public static void main(String[] args) {
        //// parameterized recursion
        int n = 3;
        function(n, 0);
    }
}
