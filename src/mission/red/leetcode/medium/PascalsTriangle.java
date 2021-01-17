package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {

    public int helper(int i, int j){
        if(j == 0 || j == i){
            return 1;
        }

        return helper(i-1, j-1) + helper(i-1, j);
    }

    public List<Integer> getRow(int rowIndex) {

        Integer[][] memory = new Integer[rowIndex+1][rowIndex+1];

        for (int i = 0; i < rowIndex+1; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    memory[i][j] = 1;
                } else{
                    memory[i][j] = memory[i-1][j-1] + memory[i-1][j];
                }
            }
        }
        return Arrays.asList(memory[rowIndex]);
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().getRow(5));
    }
}
