/*
You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards{i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.

A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.

Return the number of unoccupied cells that are not guarded.
 */

package solution;

public class Count_unguarded_cell_in_grid {
    private static int dir[] = { -1, 0, 1, 0, -1 };

    public static void dfs(int m, int n, int x, int y, int direction, int grid[][]) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 2 || grid[x][y] == 3) {
            return;
        }
        grid[x][y] = 1;
        if (direction == 0) {
            dfs(m, n, x - 1, y, direction, grid);
        } else if (direction == 1) {
            dfs(m, n, x, y + 1, direction, grid);
        } else if (direction == 2) {
            dfs(m, n, x + 1, y, direction, grid);
        } else {
            dfs(m, n, x, y - 1, direction, grid);
        }
    }

    public static int count_unguarded_cell(int m, int n, int guards[][], int walls[][]) {
        int grid[][] = new int[m][n];
        for (int guard[] : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        for (int wall[] : walls) {
            grid[wall[0]][wall[1]] = 3;
        }
        for (int guard[] : guards) {
            for (int i = 0; i < 4; i++) {
                int x = guard[0] + dir[i];
                int y = guard[1] + dir[i + 1];
                dfs(m, n, x, y, i, grid);
            }
        }

        int unGuarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unGuarded++;
                }
            }
        }
        return unGuarded;
    }

    public static void main(String[] args) {
        int m = 4, n = 6;
        int guards[][] = { { 0, 0 }, { 1, 1 }, { 2, 3 } };
        int walls[][] = { { 0, 1 }, { 2, 2 } };
        int ans = count_unguarded_cell(m, n, guards, walls);
        System.out.println(ans);
    }
}
// java solution.Count_unguarded_cell_in_grid
