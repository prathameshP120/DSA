public class CalSum {
    public static int calSum(int n) {
        if (n == 1) {
            return 1;

        }
        int Snm1 = calSum(n - 1);
        int Sn = n + Snm1;
        return Sn;

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(calSum(n));
    }

}
