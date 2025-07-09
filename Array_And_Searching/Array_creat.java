import java.util.*;

public class Array_creat {
    public static void main(String[] args) {
        int marks[]=new int[100];
        Scanner sc=new Scanner(System.in);
        marks[0]=sc.nextInt();
        marks[1]=sc.nextInt();
        marks[2]=sc.nextInt();
        System.out.println("physics ;"+marks[0]);
        System.out.println("math :"+marks[1]);
        System.out.println("chemistry :"+marks[2]);

        
        //UPDATION

        // I hava to my math marks

        marks[1]=100;
        System.out.println("math :"+marks[1]);


        //addition
        //if we have add 2 in the marks of math 
        
        marks[1]=marks[1]+2;
        System.out.println("The marks of math is"+marks[1]);
        
    }
    
}
