package mission.red.codeforces;

import java.util.Scanner;

public class BookShelves {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }

        int[][][] resultMap = new int[n][n][k + 1];

        System.out.println("Hello sukhwnat...");
        solve(input, k, 0, input.length - 1, resultMap);
        System.out.println(resultMap[0][n - 1][k - 1]);
    }

    private static int solve(int[] input, int k, int start, int end, int[][][] resultMap) {

        System.out.println("start: " + start + " end: " + end + " k: " + k);
        //validation
        if (end - start < k) {
            System.out.println("Not possible....");
            return -1;
        }

        //base cases
        if (start == end) {
            System.out.println("Base Case: start and end are same");
            return input[start];
        }
        if (end - start == k) {
            System.out.println("Base Case: number of books equals number of shelf");
            return bitwiseAnd(input, start, end);
        }
        if (k == 1) {
            System.out.println("Base Case: only one shelf");
            return sum(input, start, end);
        }

        // Check in cache....
        if (resultMap[start][end][k] != 0) {
            System.out.println("Found in cache.");
            return resultMap[start][end][k];
        }

        int ans = 0;
        for (int i = start; i < end; i++) {
            for (int j = start; j < end; j++) {
                for (int s = 1; s <= k; s++) {
                    ans = Math.max(ans, solve(input, s, i, j, resultMap));

                }
            }
        }
        return ans;
    }

    private static int sum(final int[] input, final int start, final int end) {
        int ans = input[start];
        for (int i = start + 1; i < end; i++) {
            ans = ans + input[i];
        }
        return ans;
    }

    private static int bitwiseAnd(final int[] input, final int start, final int end) {
        int ans = input[start];
        for (int i = start + 1; i < end; i++) {
            ans = ans & input[i];
        }
        return ans;
    }
}
