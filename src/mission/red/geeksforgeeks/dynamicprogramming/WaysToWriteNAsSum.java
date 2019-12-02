package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/ways-to-write-n-as-sum-of-two-or-more-positive-integers/
 * 
 * @author sukhwanp
 *
 */
public class WaysToWriteNAsSum {

    public int waysForN(int n) {
        int[] result = new int[n + 1];

        result[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = i; j <= n; j++) {
                result[j] += result[j - i];
            }
        }
        return result[n];
    }

    public static void main(String[] args) {
        System.out.println(new WaysToWriteNAsSum().waysForN(5));
    }

}
