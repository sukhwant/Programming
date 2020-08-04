package mission.red.leetcode.challenge.July;

public class ArrangeCoins {

    public int arrangeCoins(int n) {
        double ans = -1 + Math.sqrt(1 + 8*n);
        double result = Math.floor(ans/2);
        System.out.println("Result is" + result);
        return (int)result;
    }

    public static void main(String[] args) {
        ArrangeCoins arrangeCoins = new ArrangeCoins();
        arrangeCoins.arrangeCoins(1804289383);
    }
}
