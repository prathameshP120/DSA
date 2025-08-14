import java.util.ArrayList;

public class PascalsTriangle {
    public static int pascalTriangleElement(int n,int r){
            int res=1;
            for(int i=0;i<r;i++){
                 res=res*(n-i);
                 res=res/(i+1);
            }
            return res;
    }
    public static void Var_two_Optimal(int n){
         int res=1;
         //we know that first element in the row must be 1
         System.out.print(res+" ");
         for(int i=1;i<n;i++){
            res=res*(n-i);
            res=res/i;
            System.out.print(res+" ");
         }

    }
    public static ArrayList<Integer> ans(int n){
        ArrayList<Integer> ansRow=new ArrayList<>();
        int res=1;
        ansRow.add(res);
        for(int i=1;i<n;i++){
            res=res*(n-i);
            res=res/i;
            ansRow.add(res);
        }
        return ansRow;

    }
    public static void variation_three(int n){
        
        ArrayList<ArrayList<Integer>> ansList=new ArrayList<>();
          for(int r=1;r<=n;r++){
              ansList.add(ans(r));
          }
          for(ArrayList<Integer> list:ansList){
              for(int ele:list){
                  System.out.print(ele+" ");
              }
              System.out.println();
          }
    }
    public static void main(String[] args) {
        //Varaition 1
        int r=5;
        int col=3;
        //int element=(int)pascalTriangleElement(r-1,col-1);
        //System.out.println(element);

        //Variation 2 : Print the entire row

        //int n=6;
        //brute force 
        //the first element should be 1 
        // for(int c=1;c<=n;c++){
        //     int ele=(int)pascalTriangleElement(n-1, c-1);
        //     System.out.print(ele+" ");
        // }
        //optimal approach for variation 2

        //Var_two_Optimal(n);


        //Variation 3 : Print the entire pascal triangle
        int n=6; 
        variation_three(n);
    }
}
