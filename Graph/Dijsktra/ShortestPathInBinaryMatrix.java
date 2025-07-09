/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
 */

import java.util.LinkedList;
import java.util.*;

public class ShortestPathInBinaryMatrix {
    static class Tuple {
        int dist;
        int row;
        int col;

        public Tuple(int d, int r, int c) {
            this.dist = d;
            this.row = r;
            this.col = c;

        }
    }

    public static boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public static int Dijsktra(int grid[][]) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(1, 0, 0));

        int dirR[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int dirC[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
        int distance[][] = new int[n][m];

        for (int row[] : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        while (!q.isEmpty()) {
            Tuple curr = q.remove();
            int d = curr.dist;
            int r = curr.row;
            int c = curr.col;
            for (int i = 0; i < 8; i++) {
                int newR = r + dirR[i];
                int newC = c + dirC[i];
                if (isValid(newR, newC, n, m) && grid[newR][newC] == 0 && d + 1 < distance[newR][newC]) {
                    if (newR == n - 1 && newC == m - 1) {
                        return d + 1;
                    }
                    distance[newR][newC] = d + 1;
                    q.add(new Tuple(d + 1, newR, newC));
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int grid[][] = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        // output=>4
        int ans = Dijsktra(grid);
        System.out.println(ans);
    }
}
/*
 * class Solution {
 * public class Tuple{
 * int dist;
 * int r;
 * int c;
 * public Tuple(int d,int row,int col){
 * this.dist=d;
 * this.r=row;
 * this.c=col;
 * 
 * }
 * }
 * public boolean isValid(int r,int c,int n,int m){
 * return r<n && r>=0 && c<m && c>=0;
 * }
 * public int shortestPathBinaryMatrix(int[][] grid) {
 * int n=grid.length;
 * int m=grid[0].length;
 * int dr[]={-1,-1,0,1,1,1,0,-1};
 * int dc[]={0,1,1,1,0,-1,-1,-1};
 * 
 * int distance[][]=new int[n][m];
 * 
 * for(int ro[]:distance){
 * Arrays.fill(ro,Integer.MAX_VALUE);
 * }
 * distance[0][0]=0;
 * 
 * if(grid[0][0]!=0 || grid[n-1][m-1]!=0){
 * return -1;
 * }
 * if(n == 1 && m == 1){
 * return 1;
 * }
 * Queue<Tuple> q=new LinkedList<>();
 * q.add(new Tuple(1,0,0));
 * while(!q.isEmpty()){
 * Tuple curr=q.remove();
 * int d=curr.dist;
 * int r=curr.r;
 * int c=curr.c;
 * 
 * for(int i=0;i<8;i++){
 * int nr=r+dr[i];
 * int nc=c+dc[i];
 * if(isValid(nr,nc,n,m) && grid[nr][nc]==0 && d+1<distance[nr][nc]){
 * 
 * if(nr==n-1 && nc==m-1){
 * return d+1;
 * }
 * distance[nr][nc]=d+1;
 * q.add(new Tuple(d+1,nr,nc));
 * 
 * }
 * }
 * 
 * }
 * return -1;
 * }
 * }
 */