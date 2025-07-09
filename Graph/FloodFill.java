class Solution {
    public boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public void dfs(int image[][], int sr, int sc, int color, int delRow[], int delCol[], int ans[][], int iniColor) {
        ans[sr][sc] = color;

        for (int i = 0; i < 4; i++) {
            int newR = sr + delRow[i];
            int newC = sc + delCol[i];

            if (isValid(newR, newC, image.length, image[0].length) &&
                    image[newR][newC] == iniColor &&
                    ans[newR][newC] != color) {
                dfs(image, newR, newC, color, delRow, delCol, ans, iniColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        if (iniColor == color)
            return image; // Optimization to avoid unnecessary work
        int[][] ans = image;

        int[] delRow = { -1, 0, +1, 0 };
        int[] delCol = { 0, +1, 0, -1 };

        dfs(image, sr, sc, color, delRow, delCol, ans, iniColor);
        return ans;
    }
}
