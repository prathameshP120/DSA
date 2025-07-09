import java.util.*;

public class JobSequenceProblem {
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static int[] JobSchedular(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }
        int result[] = new int[maxi + 1];
        for (int i = 1; i <= maxi; i++) {
            result[i] = -1;
        }
        int countJ = 0;
        int jProfit = 0;
        ArrayList<Integer> seq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (result[j] == -1) {
                    seq.add(arr[i].id);
                    result[j] = arr[i].id;
                    jProfit += arr[i].profit;
                    countJ++;
                    break;
                }
            }
        }
        System.out.println("Sequence of jobs ");

        for (int i = 0; i < seq.size(); i++) {
            System.out.println(seq.get(i) + " ");
        }
        int ans[] = new int[2];
        ans[0] = countJ;
        ans[1] = jProfit;
        System.out.println(" result array");
        for (int e : result) {
            System.out.print(e + " ");
        }

        return ans;

    }

    public static void main(String[] args) {

        // size of array
        int n = 4;
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 2, 40);
        arr[3] = new Job(4, 2, 30);

        int ans[] = JobSchedular(arr, n);

        System.out.println("the number of jobs you performed :" + ans[0]);

        System.out.println("Maximum profit gain by doing the jobs : " + ans[1]);

    }
}