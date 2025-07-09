public class PrintAllDivisor {
    // TC=o(squroot(n))

    public static void printAllDivisor(int n) {
        int arr[] = new int[n];
        int j = 0;
        for (int i = 0; i * i <= n; i++) {
            if (n % i == 0) {
                arr[j] = i;
                j++;

            }
            if (n / i != i) {
                arr[j] = n / i;
            }
        }
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void main(String[] args) {
        int n = 36;
        printAllDivisor(n);
    }

}
