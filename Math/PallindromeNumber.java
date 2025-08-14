public class PallindromeNumber {
    public static boolean ans(int num){
        int n=num;
        int rev=0;
        while(n>0){
            int ld=n%10;
            rev=rev*10+ld;
            n=n/10;
        }
        return rev==num ? true:false;
    }
    public static void main(String[] args) {
        int num=4554;
        System.out.println(ans(num));
    }
}
