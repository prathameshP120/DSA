
/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */

public class Number_of_Island {

    public static void dfs(int i, int j, char grid[][]) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
        dfs(i, j - 1, grid);

    }

    public static int number_of_island(char grid[][]) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int num_of_island = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    num_of_island++;
                }
            }
        }

        return num_of_island;
    }

    public static void main(String[] args) {
        char grid[][] = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' },
        };

        int ans = number_of_island(grid);
        System.out.println(ans);

    }

}
