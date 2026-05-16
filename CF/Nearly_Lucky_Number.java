import java.util.Scanner;

public class Nearly_Lucky_Number {
    public static int getLucky(Long n){
          int cnt=0;
          while(n>0){
              int num=(int)(n%10);
              if(num==4 || num==7){
                  cnt++;
              }
              n/=10;
          }
          return cnt;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Long n=sc.nextLong();
        int cnt=getLucky(n);

        if(cnt==4 || cnt==7){
              System.out.println("Yes");
        }else{
              System.out.println("No");
        }

    }
}
