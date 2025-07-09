public class RemoveTheLastSetBit {
   public static void main(String[] args) {
      int n = 12;
      // 8=>1000(n-1) 7=>0111
      // 12=>1100 11=> 1011
      // 16=>10000 15=>01111
      // 16=>2^4 , 15=>8 +4 +2 +1
      // 40=>32 + 8 //39=32+4+2+1

      int ans = n & (n - 1);
      System.out.println(ans);

   }
}