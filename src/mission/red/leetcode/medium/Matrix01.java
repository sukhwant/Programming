package mission.red.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public class Pair{
        public int i;
        public int j;
        int count;

        public Pair(final int i, final int j, final int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }

    public int bfs(int i, int j, int[][] matrix){

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j, 0));
        while(!queue.isEmpty()){
            Pair curr = queue.remove();
            if(matrix[curr.i][curr.j] == 0){
                return curr.count;
            }

            if(curr.j-1>=0)
                queue.add(new Pair(curr.i, curr.j - 1, curr.count + 1));
            if(curr.j+1<= matrix[curr.i].length - 1)
                queue.add(new Pair(curr.i, curr.j + 1, curr.count + 1));
            if(curr.i-1>=0)
                queue.add(new Pair(curr.i - 1, curr.j, curr.count + 1));
            if(curr.i+1<= matrix.length - 1)
                queue.add(new Pair(curr.i + 1, curr.j, curr.count + 1));
        }
        return -1;
    }

    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = matrix.clone();
        for(int i=0;i< matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 1){
                    result[i][j] = bfs(i, j, matrix);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] input = {{0},{1}};
        System.out.println(new Matrix01().updateMatrix(input));
    }
}
