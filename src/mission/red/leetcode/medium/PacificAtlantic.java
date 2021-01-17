package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {

    public void dfs(int i, int j, boolean[][] visited, int[][] matrix){
        System.out.println(i + ":" + j);
        visited[i][j] = true;

        if(j+1 < matrix[0].length && !visited[i][j+1] && matrix[i][j+1] >= matrix[i][j])
            dfs(i, j+1, visited, matrix);
        if(j-1 >= 0 && !visited[i][j-1] && matrix[i][j-1] >= matrix[i][j])
            dfs(i, j-1, visited, matrix);
        if(i+1 < matrix.length && !visited[i+1][j] && matrix[i+1][j] >= matrix[i][j])
            dfs(i+1, j, visited, matrix);
        if(i-1 >= 0 && !visited[i-1][j] && matrix[i-1][j] >= matrix[i][j])
            dfs(i-1, j, visited, matrix);
    }
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> result = new ArrayList<>();
        if(matrix.length == 0)
            return result;

        boolean[][] pacificVisited =  new boolean[matrix.length + 1][matrix[0].length];
        for (int i = 0; i < pacificVisited.length; i++) {
            for (int j = 0; j < pacificVisited[0].length; j++) {
                pacificVisited[i][j] = false;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(0, i, pacificVisited, matrix);
        }
        for (int i = 0; i < matrix.length; i++) {
            dfs(i, 0, pacificVisited, matrix);
        }

        System.out.println("Going Atlantic");

        boolean[][] atlanticVisited =  new boolean[matrix.length + 1][matrix[0].length];
        for (int i = 0; i < atlanticVisited.length; i++) {
            for (int j = 0; j < atlanticVisited[0].length; j++) {
                atlanticVisited[i][j] = false;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix.length - 1, i, atlanticVisited, matrix);
        }
        for (int i = 0; i < matrix.length; i++) {
            dfs(i, matrix[0].length - 1, atlanticVisited, matrix);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(atlanticVisited[i][j] && pacificVisited[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {};

        List<List<Integer>> result = new PacificAtlantic().pacificAtlantic(matrix);
        System.out.println("Hello...");
    }
}
