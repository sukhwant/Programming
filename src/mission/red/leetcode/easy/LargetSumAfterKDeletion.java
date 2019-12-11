package mission.red.leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations
 */
public class LargetSumAfterKDeletion {

    public static void main(String[] args) {
        int[] input = {3, -1, 0, 2};
        int k = 2;
        System.out.println(new LargetSumAfterKDeletion().largestSumAfterKNegations(input, k));
    }

    /**
     * Complexity - O(k.n)
     * @param input
     * @param K
     * @return
     */
    public int largestSumAfterKNegations(int[] input, int K) {
        for (int i = 0; i < K; i++) {
            int minIndex = 0;
            for (int j = 0; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            input[minIndex] *= -1;
        }

        return Arrays.stream(input).sum();
    }

    /**
     *
     * @param input
     * @param K
     * @return
     */
    public int largestSumAfterKNegationsWithPriorityQueue(int[] input, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (Integer i : input) {
            priorityQueue.add(i);
        }

        for (int i = 0; i < K; i++) {
            priorityQueue.add(-1 * priorityQueue.poll());
        }
        int sum = 0;
        while (!priorityQueue.isEmpty()) {
            sum += priorityQueue.poll();
        }
        return sum;
    }

}
