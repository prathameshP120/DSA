public class SwapTwoNumbers {
    public static void swap(int a, int b) {
        // property of xor => even number of 1s => gives 0
        // means if you do the xor number itself => a^a=0;
        a = a ^ b;
        b = a ^ b; // =>(a^b)^b=a
        a = a ^ b; // =>a^(a^b)=b
        System.out.println("After Swapping  : ");

        System.out.println("the value of a is " + a);
        System.out.println("the value of b is " + b);
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println("the value of a is :" + a);
        System.out.println("the value b is :" + b);
        swap(a, b);
    }
}
