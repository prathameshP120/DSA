public class OptimizedPower {
    public static int Optimizedpower(int a, int n) {
        if (n == 0) {
            return 1;

        }
        // Even
        int halfPower = Optimizedpower(a, n / 2);
        int halfPowerSq = halfPower * halfPower;

        if (n % 2 != 0) {
            halfPowerSq = a * halfPowerSq;

            return halfPowerSq;

        }

        return halfPowerSq;
    }

    public static void main(String[] args) {
        int a = 4;
        int n = 3;
        System.out.println(Optimizedpower(a, n));
    }

}
