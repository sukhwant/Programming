package leetcode.mission.red;

public class StockSell {

    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];

        int answer = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                answer = Math.max(answer, prices[i] - min);
            }
            min = Math.min(min, prices[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] input = {7, 6, 4, 3, 1};
        System.out.println(new StockSell().maxProfit(input));
    }
}
