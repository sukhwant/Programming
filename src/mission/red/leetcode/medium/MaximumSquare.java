package mission.red.leetcode.medium;

import java.util.Arrays;

public class MaximumSquare {

    public int findAns(char[][] matrix, int[][] ans, int r, int c){

        if(r == matrix.length - 1 ){
            ans[r][c] = matrix[r][c] == '1' ? 1 : 0;
            return ans[r][c];
        }
        if(c == matrix[0].length - 1 ){
            ans[r][c] = matrix[r][c] == '1' ? 1 : 0;
            return ans[r][c];
        }

        if(matrix[r][c] == '0'){
            ans[r][c] = 0;
            return ans[r][c];
        }

        if(ans[r][c] != -1){
            return ans[r][c];
        }

        ans[r][c] = Math.min(findAns(matrix, ans, r, c + 1), Math.min(findAns(matrix, ans, r + 1,
            c + 1), findAns(matrix, ans, r+1, c ))) + 1;
        return ans[r][c];
    }

    public int maximalSquare(char[][] matrix) {

        int[][] ans = new int[matrix.length][matrix[0].length];
        Arrays.stream(ans).forEach(a -> Arrays.fill(a, -1));

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, findAns(matrix, ans, i, j));
            }
        }

        return max*max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1', '0', '0','1','0'}
        };

        System.out.println(new MaximumSquare().maximalSquare(matrix));
    }
}
