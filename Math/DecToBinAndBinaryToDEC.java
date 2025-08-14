import java.sql.Time;

public class DecToBinAndBinaryToDEC {
    public static int DecToBin(int n){
        int p=0;
        int binary=0;
        while(n>0){
             int rem=n%2; 
             binary=binary+(int)(rem*Math.pow(10,p));
             p++;
             n=n/2;
        }
        return binary;

      //Dominant factor: loop iterations → O(log n)
      // ✅ Time Complexity: O(log n) (base 2)
    }
    public static int BinToDec(int n){
         int dec=0;
         int p=0;
         while(n>0){
             int ld=n%10;
             dec=dec+(int)(ld*Math.pow(2, p));
             n=n/10;
             p++;
         }
         return dec;
       //Again, loop runs in O(log n) (where n is the decimal equivalent of the binary input)
       //✅Time Complexity: O(log n)
    }
    public static void main(String[] args) {
        //int n=13;
        //int ans=DecToBin(n);
        int n=1101;
        int ans=BinToDec(n);
        System.out.println(ans);
    }
}
