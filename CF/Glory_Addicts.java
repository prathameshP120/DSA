import java.util.*;

public class Glory_Addicts {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();

            int[] type = new int[n];
            for (int i = 0; i < n; i++) {
                type[i] = sc.nextInt();
            }

            List<Long> fire = new ArrayList<>();
            List<Long> frost = new ArrayList<>();

            long totalSum = 0;

            for (int i = 0; i < n; i++) {
                long dmg = sc.nextLong();
                totalSum += dmg;

                if (type[i] == 0)
                    fire.add(dmg);
                else
                    frost.add(dmg);
            }

            Collections.sort(fire);
            Collections.sort(frost);

            int f = fire.size();
            int r = frost.size();

            int m = Math.min(f, r);

            long bonus = 0;

            // Double smallest m elements from both
            for (int i = 0; i < m; i++) {
                bonus += fire.get(i);
                bonus += frost.get(i);
            }

            long answer = totalSum + bonus;

            // If sizes equal, subtract smallest overall once
            if (f == r && m > 0) {
                answer -= Math.min(fire.get(0), frost.get(0));
            }

            System.out.println(answer);
        }
    }
}