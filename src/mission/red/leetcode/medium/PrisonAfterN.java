package mission.red.leetcode.medium;

/**
 * https://leetcode.com/problems/prison-cells-after-n-days
 */
public class PrisonAfterN {

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 1, 1, 0, 0, 1};
        System.out.println(new PrisonAfterN().prisonAfterNDays(input, 7));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {

        int state = 0;
        for (int i = 0; i < 8; ++i) {
            if (cells[i] > 0) {
                state ^= 1 << i;
            }
        }
        if (N % 14 == 0) {
            N = 14;
        } else {
            N %= 14;

        }

        while (N > 0) {
            state = nextState(state);
            N--;
        }

        int[] ans = new int[8];
        for (int i = 0; i < 8; ++i) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }

    private int nextState(final int state) {
        int ans = 0;

        for (int i = 1; i <= 6; ++i) {
            if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
                ans ^= 1 << i;
            }
        }

        return ans;
    }
}
