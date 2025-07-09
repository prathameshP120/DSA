import java.util.Arrays;

public class MinAbsoluteDifferenc {
    public static void main(String[] args) {
        int A[] = { 1, 3, 2 };
        int B[] = { 2, 1, 3 };
        Arrays.sort(A);
        Arrays.sort(B);

        int minAbsDiff = 0;
        for (int i = 0; i < A.length; i++) {
            minAbsDiff += Math.abs(A[i] - B[i]);

        }

        System.out.println("Minimum absoulute difference is : " + minAbsDiff);

    }

}
