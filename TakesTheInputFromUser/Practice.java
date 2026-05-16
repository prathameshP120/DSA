package TakesTheInputFromUser;

import java.util.Scanner;

//take space seperated array integer
public class Practice {
    public void TakeSpaceSeperatedIntegerArray(){
          Scanner sc=new Scanner(System.in);
          String tokens[]=sc.nextLine().split(" ");
          int n=tokens.length;
          int arr[]=new int[n];
          for(int i=0;i<n;i++){
              arr[i]=Integer.parseInt(tokens[i]);
          }
          for(int ele:arr){
            System.out.print(ele+" ");
          }
    }
    public static void TakeSpaceSeperatedIntegerOnSameLine(){
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         int m=sc.nextInt();
         System.out.println(n);
         System.out.println(m);
    }
    public static void main(String args[]){
       // TakeSpaceSeperatedIntegerArray();
        TakeSpaceSeperatedIntegerOnSameLine();
    }
}
