// A celebrity is a person who is known by everyone else at the party but does not know anyone in return. Given a square matrix M of size N x N where M{i][j] is 1 if person i knows person j, and 0 otherwise, determine if there is a celebrity at the party. Return the index of the celebrity or -1 if no such person exists.
// Note that M[i][i] is always 0.
// Examples:
// Input: M = [ [0, 1, 1, 0], [0, 0, 0, 0], [1, 1, 0, 0], [0, 1, 1, 0] ]
// Output: 1
// Explanation: Person 1 does not know anyone and is known by persons 0, 2, and 3. Therefore, person 1 is the celebrity.
// Input: M = [ [0, 1], [1, 0] ]
// Output: -1
// Explanation: Both persons know each other, so there is no celebrity.



public class TheCelebrityProblems {
    //mat[1][0]=0 =>it means 1 does not know the zero 
    //mat[1][0]=1 => It means 1 does know the zero 


    public static int bruteForce(int mat[][]){
        int knowMe[]=new int[mat.length];
        int iKnow[]=new int[mat.length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[j][i]==1){
                    knowMe[i]++;
                    iKnow[j]++;
                }
            }
        }

       // getting the answer 
       int ans=-1;
       for(int i=0;i<knowMe.length;i++){
           if(iKnow[i]==0 && knowMe[i]==(mat.length-1)){
              ans=i;
           }
       }
       return ans;
          
    }
    
     public static int Optimal(int[][] M, int n) {
        int top = 0;
        int bottom = n - 1;

        // Find potential celebrity
        while (top < bottom) {
            if (M[top][bottom] == 1) {
                top++;
            } else if (M[bottom][top] == 1) {
                bottom--;
            } else {
                top++;
                bottom--;
            }
        }

        // Verify if candidate is actually a celebrity
        if (top > bottom) return -1;

        for (int i = 0; i < n; i++) {
            if (i == top) continue;

            // Celebrity must not know anyone and must be known by everyone
            if (M[top][i] == 0 && M[i][top] == 1) {
                continue;
            } else {
                return -1;
            }
        }

        return top;
    }





    public static void main(String[] args) {
        int mat[][]={{0, 1, 1, 0}, {0, 0, 0, 0}, {1, 1, 0, 0}, {0, 1, 1, 0}};
        //Brute force Approach
        //int ans=bruteForce(mat);

        //Optimal solution 
        int ans=Optimal(mat, mat.length);
        System.out.println(ans);
    }
}
