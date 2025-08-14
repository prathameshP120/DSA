import java.util.*;

public class EvenorOdd {
    public static void evenOrodd(int n) {
        // n=2:(0100 & 1)=0000
        if ((n & 1) == 0) {
            System.out.println("number is even");
        } else {
            System.out.println("number is odd");
        }
    }

    public static void main(String[] args) {
        evenOrodd(4);
        
    }
}
 // TC=  O(log10N + 1) where N is the input number. The time complexity is determined by the number of digits in the input integer N. In the worst case when N is a multiple of 10 the number of digits in N is log10 N + 1.