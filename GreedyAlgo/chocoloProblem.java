// Given a board of dimensions n × m that needs to be cut into n × m squares. The cost of making a cut along a horizontal or vertical edge is provided in two arrays:

// x[]: Cutting costs along the vertical edges (length-wise).
// y[]: Cutting costs along the horizontal edges (width-wise).
// Find the minimum total cost required to cut the board into squares optimally.

// Examples: 

// Input: x[] = [2, 1, 3, 1, 4], y[] = [4, 1, 2], n = 4, m = 6
// Output: 42


import java.util.Arrays;



class chocoloProblem {
    
    static int minCost(int n, int m, 
                                     int[] x, int[] y) {

        // Sort the cutting costs in ascending order
        Arrays.sort(x);
        Arrays.sort(y); 

        int hp = 1, vp = 1; 
        int i = x.length - 1, j = y.length - 1; 
        int totalCost = 0;
        while (i >= 0 && j >= 0) {
            
            // Choose the larger cost cut to 
            // minimize future costs
            if (x[i] >= y[j]) {
                totalCost +=hp*x[i]; 
                vp++;
                i--;
            }
            else{
                totalCost += vp*y[j] ;  //vp*horizontal cut price    
                hp++;
                j--;
            }
        }
        // Process remaining vertical cuts
        while (i >= 0) {
            totalCost += x[i] * hp;
            vp++;
            i--;
        }

        // Process remaining horizontal cuts
        while (j >= 0) {
            totalCost += y[j] * vp;
            hp++;
            j--;
        }
        return totalCost;
    }
    public static void main(String[] args) {
        
        int n = 4,m = 6;
        int[] x = {2, 1, 3, 1, 4};
        int[] y = {4, 1, 2};

        System.out.println(minCost(n, m, x, y));
    }
}