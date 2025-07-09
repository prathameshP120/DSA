import java.util.*;

public class MaxSubArraySum {
    public static void max_sub_array_sum(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < numbers.length; i++) { // for starting element of an array
            int start = i;

            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currentSum = 0;
                for (int k = start; k <= end; k++) {
                    currentSum += numbers[k];
                }
                System.out.println(currentSum);
                if (maxSum < currentSum) {
                    maxSum = currentSum;

                }
            }
        }
        System.out.println("max sum is" + maxSum);

    }

    public static void main(String[] args) {
        int numbers[] = { 1, -2, 6, -1, 3 };
        max_sub_array_sum(numbers);

    }
}
