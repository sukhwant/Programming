package mission.red.leetcode.medium;

import java.util.Arrays;

public class MatrixZero {

    public void setZeroes(int[][] matrix) {

        boolean rowZero = false;
        boolean colZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
                if(matrix[0][i] == 0){
                    rowZero = true;
                    break;
                }
        }

        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                colZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if((matrix[i][0] == 0) || (matrix[0][j] == 0)){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowZero) {
            Arrays.fill(matrix[0], 0);
        }

        if(colZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        System.out.println("Hello...");
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new MatrixZero().setZeroes(matrix);
    }
}
