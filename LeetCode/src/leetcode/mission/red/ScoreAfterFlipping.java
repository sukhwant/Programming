package leetcode.mission.red;

/**
 * https://leetcode.com/problems/score-after-flipping-matrix/
 * 
 * @author sukhwanp
 *
 */
public class ScoreAfterFlipping {

    public int matrixScore(int[][] input) {

        // make 1st col all 1's
        for (int i = 0; i < input.length; i++) {
            if (input[i][0] == 0) {
                flip(input, true, i);
            }
        }

        // Keep flippling columns if #1's < #0's
        for (int col = 1; col < input[0].length; col++) {
            int oneCount = 0;
            int zeroCount = 0;
            for (int row = 0; row < input.length; row++) {
                if (input[row][col] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            if (oneCount < zeroCount) {
                flip(input, false, col);
            }
        }

        // Convert to decimal

        int num = 0;

        for (int row = 0; row < input.length; row++) {
            num += convertToDecimal(input[row]);
        }
        return num;
    }

    private Integer convertToDecimal(int[] input) {
        Integer num = 0;
        for (int i = 0; i < input.length; i++) {
            num = num * 10 + input[i];
        }
        return Integer.parseInt(String.valueOf(num), 2);
    }

    private void flip(int[][] input, boolean isRow, int index) {

        if (isRow) {
            for (int i = 0; i < input[index].length; i++) {
                input[index][i] = input[index][i] == 0 ? 1 : 0;
            }
        } else {
            for (int i = 0; i < input.length; i++) {
                input[i][index] = input[i][index] == 0 ? 1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};

        System.out.println(new ScoreAfterFlipping().matrixScore(input));
    }
}
