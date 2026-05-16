import java.util.*;
class A_Race{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0){
                int a=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
            if(x>y){
                int temp=x;
                x=y;
                y=temp;
             }
        if(Math.abs(a-x)>Math.abs(x-y)){
             System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        sc.nextLine();
        }
    }
}