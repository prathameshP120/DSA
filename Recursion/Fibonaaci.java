// public class Fibonaaci {
//     public static int fib(int n) {
//         if (n == 0 || n == 1) {
//             return n;
//         }

//         int FibN = fib(n-1) + fib(n-2);

//         return FibN;
//     }
  
//     public static void main(String[] args) {
//         int n = 6;
//         System.out.println(fib(n));
//     }
// }
//Fibonacci Series using Recursion (Complete Code)
public class Fibonaaci {

    // Recursive function to find nth Fibonacci number
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 10; // number of terms

        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}
