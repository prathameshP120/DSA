import java.util.*;
public class Stones_on_the_Table {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        int cnt=0;
        char prev=s.charAt(0);
        for(int i=1;i<n;i++){
              if(prev==s.charAt(i)){
                  cnt++;
              }
              prev=s.charAt(i);
        }
        System.out.println(cnt);
    }
}
