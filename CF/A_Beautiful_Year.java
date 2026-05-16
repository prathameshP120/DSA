import java.util.*;
public class A_Beautiful_Year {
    public static boolean checkDistinct(int n){
          boolean mark[]=new boolean[10];
          while(n>0){
              int num=n%10;
              if(mark[num]==true){
                  return false;
              }
              mark[num]=true;
              n/=10;
          }
          return true;
    }
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=n+1;true;i++){
              if(checkDistinct(i)){ 
                  System.out.println(i);
                  break;
              }
        }

     }   
}
