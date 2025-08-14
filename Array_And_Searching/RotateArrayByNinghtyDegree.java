// Example 1:
// Input: [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]
// Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix.

// Example 2:
// Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output:[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix

public class RotateArrayByNinghtyDegree {
    public static int[][] BrueteForce(int arr[][]){
        int rotated[][]=new int[arr.length][arr[0].length];
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                rotated[j][n - i - 1]=arr[i][j];
            }
        }
        return rotated;
    }
    
public static int[][] optimal(int[][] matrix) {
    int n=matrix.length;
    for(int i=0; i<(n+1)/2;i++){  /* It keep the count of the rings 
    [i=0=> outerRing && i=1 => innerRing]*/
    for(int j=0; j<n/2; j++){  /*It keep the track the element in the which your choosing */
      

        //left bottom
        int temp=matrix[n-1-j][i];

        //leftBottom=rightBottom
        matrix[n-1-j][i]=matrix[n-1-i][n-j-1];

        //rightBottom=topRight;
        matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
        
        //topRight=topleft
        matrix[j][n-1-i]=matrix[i][j];
        matrix[i][j]=temp;



             }
        }
        return matrix;

    }

    public static void main(String[] args) {
        
   
      int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
       // int rotated[][] = BrueteForce(arr);
       int rotated[][] = optimal(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
 }
}
