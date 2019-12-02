package mission.red.leetcode;

public class BestTimeStock {

    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;

        int currPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > currPrice) {
                maxProfit += prices[i] - currPrice;
            }
            currPrice = prices[i];
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] input = {7, 6, 4, 3, 1};
        int maxProfit = new BestTimeStock().maxProfit(input);
        System.out.println(maxProfit);
    }

}
