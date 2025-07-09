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