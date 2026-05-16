import java.util.*;
public class Third{
     public static void solve(Scanner sc){
          int n=sc.nextInt();
          String s=sc.next();
          int start=0;
          int i=1;
          StringBuilder sb=new StringBuilder();
          while(i<n){
              if(s.charAt(i)==s.charAt(start)){
                  sb.append(s.substring(start,i+1));
                  start=i+1;
                  i++;
              }
              i++;
          }
          if(sb.length()==s.length()){
              System.out.println("YES");
          }else{
              System.out.println("NO");
          }
          
     }
    public static void main(String args[]){
           Scanner sc=new Scanner(System.in);
           int t=sc.nextInt();
           while(t-->0){
              solve(sc);
           }
    }
}