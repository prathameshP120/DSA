public class Best_Time_BAndS_stock {
    public static int profit(int prices[]) {
        int maxProfit = 0;
        int BP = Integer.MAX_VALUE;
        for (int i = 0; i <= prices.length - 1; i++) {
            if (prices[i] > BP) {
                int profit = prices[i] - BP;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                BP = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(profit(prices));
    }

}
