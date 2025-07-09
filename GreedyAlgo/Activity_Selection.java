import java.util.*;

public class Activity_Selection {

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < activities.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // end time basis sorted
        Arrays.sort(activities, Comparator.comparingDouble(i -> i[2]));
        int maxactivity = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        // 1st Activity
        maxactivity = 1;
        ans.add(activities[0][0]);
        int lastend = activities[0][2];
        for (int i = 1; i < activities.length; i++) {
            if (activities[i][1] >= lastend) {
                lastend = activities[i][2];
                maxactivity++;
                ans.add(activities[i][0]);
            }
        }
        System.out.println("Max Activities " + maxactivity);
        System.out.println();
        for (int i = 0; i < ans.size(); i++) {
            System.out.println("A" + ans.get(i));
        }
        System.out.println();
    }
}
