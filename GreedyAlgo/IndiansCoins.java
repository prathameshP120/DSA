import java.util.*;

public class IndiansCoins {
    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int amount = 590;
        int cnt = 0;

        // Sorting in desending Order

        Arrays.sort(coins, Collections.reverseOrder());
        // first time it give me error beacuse we declare coins[] array as int
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            while (coins[i] <= amount) { // if we used if statement it will give me error
                cnt++;
                ans.add(coins[i]);
                amount -= coins[i];
            }

        }
        System.out.println("Total minimum coins used : " + cnt);
    }

}
