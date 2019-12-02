package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/ugly-numbers/
 * 
 * @author sukhwanp
 *
 */
public class UglyNumber {

    private static int uglyNumber(int n) {
        int[] ans = new int[n];

        ans[0] = 1;
        int i2, i3, i5;
        i2 = i3 = i5 = 0;

        int min;

        for (int i = 1; i < n; i++) {

            min = Math.min(ans[i2] * 2, Math.min(ans[i3] * 3, ans[i5] * 5));

            if (min == ans[i2] * 2) {
                i2++;
            }
            if (min == ans[i3] * 3) {
                i3++;
            }
            if (min == ans[i5] * 3) {
                i5++;
            }

            ans[i] = min;
        }
        return ans[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(uglyNumber(n));
    }

}
