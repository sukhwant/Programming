package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/super-ugly-number-number-whose-prime-factors-given-set/
 * 
 * @author sukhwanp
 *
 */
public class SuperUglyNumber {

    private static int uglyNumber(int n, int[] primeSet) {
        int[] ans = new int[n];

        ans[0] = 1;
        int[] primeSetCounter = new int[primeSet.length];

        for (int i = 1; i < n; i++) {
            int min = (int) Double.POSITIVE_INFINITY;

            for (int j = 0; j < primeSet.length; j++) {
                min = Math.min(min, ans[primeSetCounter[j]] * primeSet[j]);
            }

            for (int j = 0; j < primeSet.length; j++) {
                if (min == ans[primeSetCounter[j]] * primeSet[j]) {
                    primeSetCounter[j]++;
                }
            }

            ans[i] = min;
        }
        return ans[n - 1];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] primeSet = { 2, 5 };
        System.out.println(uglyNumber(n, primeSet));
    }

}
