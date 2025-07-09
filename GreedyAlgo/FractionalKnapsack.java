
import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int wt[] = { 10, 20, 30 };
        int W = 50;
        // wt->min val->max ratio=val/wt;

        double ratio[][] = new double[val.length][2];
        // 0th col=>idx, 1st col=>ratio

        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = (val[i] / (double) wt[i]);
        }
        Arrays.sort(ratio, Comparator.comparingDouble(i -> i[1]));
        int capacity = W;
        double finalVal = 0;

        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= wt[idx]) {
                finalVal += val[idx];
                capacity -= wt[idx];
            } else {
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("finalVal : " + finalVal);
    }
}
