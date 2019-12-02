package mission.red.geeksforgeeks.medium;

import java.util.PriorityQueue;

/**
 * Running Median.
 * 
 * @author sukhwanp
 *
 */
public class RunningMedian {

    private static int runningMedian(int[] input) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> x - y);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);

        int median = 0;
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(input[i]);
                median = input[i];
            } else {
                if (input[i] < median) {
                    maxHeap.add(input[i]);
                } else {
                    minHeap.add(input[i]);
                }
            }
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
        }
        return findMedian(minHeap, maxHeap);
    }

    private static int findMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        int[] input = { 2, 5, 7, 1, 3, 6, 8, 0, 9 };
        System.out.println(runningMedian(input));
    }

}
