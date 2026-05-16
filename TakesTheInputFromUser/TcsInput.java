
package TakesTheInputFromUser;
import java.util.*;

import javax.sound.sampled.SourceDataLine;
public class TcsInput {
    public static void takeArrayAsInput1(){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String parts[]=line.split(" ");
        int n=parts.length;
        int arr[]=new int[n];
        for(int i=0;i<parts.length;i++){
            arr[i]=Integer.parseInt(parts[i]);
        }
        for(int ele: arr){
            System.out.print(ele+ " ");
        }

// 10 20 30 40
// This line is read as:
// line = "10 20 30 40"
// After split(" "):
// parts = ["10", "20", "30", "40"]
// After conversion:
// arr = [10, 20, 30, 40]
// Output:
// [10, 20, 30, 40]

}
    public static void takeArrayAsInput_two(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();          // e.g. "1,2,3,4"
        String[] parts = line.split(",");     // split by comma

        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++)
            arr[i] = Integer.parseInt(parts[i]);  // convert each to int

        System.out.println(Arrays.toString(arr));
    }


 public static void takeArrayAsInput_three(){
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine().trim();   // "[1, 2, 3, 4]"
    line = line.replaceAll("\\[|\\]", ""); // remove brackets

    String[] parts = line.split(",");      // split by comma

    int[] arr = new int[parts.length];

    for (int i = 0; i < parts.length; i++){
        arr[i] = Integer.parseInt(parts[i]);
    }
    System.out.println(Arrays.toString(arr));

}
  public static void StringOfSpaceSeperated_word(){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String word[]=line.split(" ");
        System.out.println(Arrays.toString(word));
  }
  public static void floatingPointOutput(){
//Output with decimal points
// Let’s take an example:
// If you have a floating-point number (like 12.34567), you need to print it as
// 12.346
  Scanner sc=new Scanner(System.in);
  double num=sc.nextDouble();
  System.out.printf("%.3f",num);

  }
  public static void Two_D_ArrayInputgivenInStringformat(){
//Problem Description (from image text)
//2d Array Input given in String format
//rows = 3 , cols = 2
//input = "1, 2, 3, 4, 5, 6"
//You must convert the string into a 2D integer array (matrix) of size 3x2.

        int rows = 3, cols = 2;

        Scanner sc = new Scanner(System.in);

        // Example input: "1, 2, 3, 4, 5, 6"
        String line = sc.nextLine();

        // Split by comma
        String[] parts = line.split(",");

        int[][] matrix = new int[rows][cols];

        int k = 0;

        // Fill the 2D matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(parts[k].trim());
                k++;
            }
        }

        // Print matrix
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }


  
    public static void main(String args[]){
          //takeArrayAsInput_one();
          //takeArrayAsInput_two();
          //takeArrayAsInput_three();
          // StringOfSpaceSeperated_word();
          // floatingPointOutput();
          Two_D_ArrayInputgivenInStringformat();
    }
}
