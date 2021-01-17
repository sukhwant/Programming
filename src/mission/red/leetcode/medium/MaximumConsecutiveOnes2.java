package mission.red.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumConsecutiveOnes2 {

    public int longestOnes(int[] arr, int k) {

        int start = 0;
        int max = 0;
        Queue<Integer> queue = new LinkedList<>();
        int end = 0;

        while(end < arr.length){
            if(arr[end] == 0){
                queue.add(end);
                if(queue.size() > k){
                    max = Math.max(max, end - start);
                    start = queue.poll() + 1;
                }
            }
            end++;
        }

        return Math.max(max, end - start);

    }

    public static void main(String[] args) {

        int[] input = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        System.out.println(new MaximumConsecutiveOnes2().longestOnes(input, k));
    }
}
