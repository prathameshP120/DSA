
//Two pointer approach
import java.util.*;

public class MaxWater {
    public static int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length - 1;
        int max = 0;
        while (lp < rp) {
            int w = rp - lp;
            int h = Math.min(height[lp], height[rp]);
            int area = h * w;
            max = Math.max(max, area);
            if (height[lp] < height[rp]) {
                lp++;
            } else if (height[lp] > height[rp]) {
                rp--;
            } else {
                lp++;
                rp--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Maximum Area :" + maxArea(height));
    }

}
