import java.util.*;

public class Maximum_HeightBy_Stacking_Cuboids {

    public static boolean check(int[] curr, int[] prev) {
        // curr -> large box
        // prev -> small box
        return prev[0] <= curr[0] && prev[1] <= curr[1] && prev[2] <= curr[2];
    }

    public static int solveUsingTabulationSO(List<int[]> cuboids) {
        int n = cuboids.size();

        int[] currRow = new int[n + 1];
        int[] nextRow = new int[n + 1];

        for (int currIndex = n - 1; currIndex >= 0; currIndex--) {
            for (int prevIndex = currIndex - 1; prevIndex >= -1; prevIndex--) {

                int include = 0;
                if (prevIndex == -1 || check(cuboids.get(currIndex), cuboids.get(prevIndex))) {
                    int heightToAdd = cuboids.get(currIndex)[2];
                    include = heightToAdd + nextRow[currIndex + 1];
                }

                int exclude = nextRow[prevIndex + 1];
                currRow[prevIndex + 1] = Math.max(include, exclude);
            }
            // shifting
            nextRow = currRow.clone();
        }

        return nextRow[0];
    }

    public static int maxHeight(List<int[]> cuboids) {
        // Sorting each cuboid and then sorting the list of cuboids
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        cuboids.sort((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else if (a[1] != b[1])
                return a[1] - b[1];
            else
                return a[2] - b[2];
        });

        return solveUsingTabulationSO(cuboids);
    }

    public static void main(String[] args) {
        Maximum_HeightBy_Stacking_Cuboids solution = new Maximum_HeightBy_Stacking_Cuboids();

        List<int[]> cuboids = new ArrayList<>();
        cuboids.add(new int[] { 50, 45, 20 });
        cuboids.add(new int[] { 95, 37, 53 });
        cuboids.add(new int[] { 45, 23, 12 });

        System.out.println(solution.maxHeight(cuboids)); // Output example
    }
}
