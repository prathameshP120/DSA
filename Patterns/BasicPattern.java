public class BasicPattern {
    public static void pattern_one() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern_number_one(){
        for(int i=0;i<=4;i++){
              for(int j=0;j<=i;j++){
                   System.out.print(j+1+" ");
              }
              System.out.println();
        }
    }
    public static void pattern_number_two(){
         for(int i=0;i<=4;i++){
            for(int j=0;j<=i;j++){
                  System.out.print(i+1+" ");
            }
            System.out.println();
         }
    }

  

    public static void pattern_two(){
          for(int i=1;i<=5;i++){
              for(int j=1;j<=(5-i+1); j++){
                   System.out.print("*"+" ");
              }
              System.out.println();
          }
    }

    // half Pyramid pattern
    public static void pattern_three() {
          //number of rows 
          int n=5;
           for(int i=0;i<=4;i++){
               //space 
               //for better understanding instead of printing space try to print other symbol
               for(int j=1; j<=(n-i-1);j++){
                    System.out.print(" "); 
               }
               //print star
               for(int j=1; j<=(2*i+1);j++){
                    System.out.print("*");
               }
               //print space 
                for(int j=1; j<=(n-i-1);j++){
                    System.out.print(" ");
               }
               System.out.println();

           }
    }
    public static void pattern_three_opposite(){
        int n=5;
        for(int i=0;i<n;i++){
              
            //space
            for(int j=0;j<i;j++){
                System.out.print("$");
            }
            //star=> in each row=2n-(2i-1);
            for(int j=0;j<(2*n-(2*i+1));j++){
                System.out.print("*");
            }
            //space 
            for(int j=0;j<i;j++){
                System.out.print("$");
            }
            System.out.println();

        }
    }
    
    public static void pattern_four(){
        int n=5;

        for(int i=1;i<=(2*n-1);i++){
            int stars=i;
            

            //as row>n => we simple invert the result
            if(i>n){
                stars=2*n-i;
            }
            for(int j=1;j<=stars;j++){
                  System.out.print("*");
            }
            System.out.println();
        }
    }


    // character pattern Capital A/BC/DEF/GHIJ
    public static void char_Pattern() {
        int n = 4;
        char ch = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }

    // rectangle for * ( BIG Hole in it ) pattern of 5 BY 4
    public static void rectangle_pattern() {
        int n = 4;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || i == 3 || j == 0 || j == 4) {
                    System.out.print("*" + " ");
                } else {
                    System.out.print(" " + " ");
                }
            }
            System.out.println();
        }
    }

    // inverted rotated half pyramid => [SSS*/SS**/S***/****]
    public static void inverted_Rotated_half_Pyramid() {
        int n = 4;
        for (int i = 0; i < n; i++) {
            // for printing space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" " + " ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    // Floyd's Triangle

    public static void floyd_pattern() {
        int num = 1;
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();

        }
    }

    // 01_triangle=>1/01/101/0101/10101
    public static void One_Zero_triangle() {
        int n = 5;
        int start=0;
        for (int i = 0; i < n; i++) {
            if(i%2==0){
                start=1;
            }else{
                start=0;
            }
            for(int j = 0; j <= i; j++) {
                 System.out.print(start+" ");
                 start=1-start;  
            }
            System.out.println();
        }
    }
// ButterFly Pattern 
    public static void main(String[] args) {
        //pattern_one();
        //pattern_number_one();
        //pattern_number_two();
        //pattern_two();
        //pattern_three();
        //pattern_three_opposite();
        //pattern_four();
         //One_Zero_triangle();
         char_pattern_one();
         //char_Pattern();
        // rectangle_pattern();
        // inverted_Rotated_half_Pyramid();
        // floyd_pattern();
        
    }
}