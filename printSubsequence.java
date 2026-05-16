import java.util.*;

public class printSubsequence{
      public static boolean ans(int n){
          int sum=0;
          int number=n;
          int k=String.valueOf(n).length();
          while(n>0){
             int lasd=n%10;
             sum+=Math.pow(lasd,k);
             n=n/10;
          }

          if(sum==number){
             return true;
          }
          return false;
      }
      public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(ans(n));
    }
    }
