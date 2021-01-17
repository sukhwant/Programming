package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DiagonalSort {

    public int[][] diagonalSort(int[][] mat) {

        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                diagonalMap.putIfAbsent((i-j), new ArrayList<>());
                diagonalMap.get((i-j)).add(mat[i][j]);
            }
        }

        for (Entry<Integer, List<Integer>> entry:diagonalMap.entrySet()){
            Collections.sort(entry.getValue());
        }

        for (int i = 0; i < mat.length; i++) {
            //System.out.println("I is: " + i);
            int row = i;
            int col = 0;
            while(row < mat.length && col < mat[0].length){
                //System.out.println(row + " : " + col);
                mat[row][col] = diagonalMap.get(row-col).get(col);
                row++;
                col++;
            }
        }
        //System.out.println("Hello World.....");
        for (int i = 0; i < mat[0].length; i++) {
            //System.out.println("I is: " + i);
            int row = 0;
            int col = i;
            while(row < mat.length && col < mat[0].length){
                //System.out.println(row + " : " + col);
                mat[row][col] = diagonalMap.get(row-col).get(row);
                row++;
                col++;
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int[][] ans = new DiagonalSort().diagonalSort(mat);
        System.out.println(mat);
    }
}
