package mission.red.leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList<Integer>();
        int[] answer = new int[nums.length - k + 1];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i >= k - 1) {
                answer[count++] = nums[deque.peek()];
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(new SlidingWindowMaximum().maxSlidingWindow(nums, k));
    }
}
