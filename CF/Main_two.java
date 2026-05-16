import java.util.*;
public  Main_two{
     public static void solve(sc){
          int n=sc.nextInt();
          String s=sc.nextLine();
          int s=0;
          int i=1;
          StringBuilder sb=new StringBuilder();
          while(i<n){
              if(sb.charAt(i)==sb.charAt(s)){
                  sb.append(s.substring(s,i+1));
                  s=i+1;
              }
              i++;
          }
          if(sb.size()==s.length()){
              System.out.println("YES");
          }else{
              System.out.println("NO");
          }
          
     }
    public static void main(String args[]){
           Scanner sc=new Scanner(System.in);
           int t=sc.nextInt();
           while(t->0){
              solve(sc);
           }
    }
}