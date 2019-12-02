package mission.red.leetcode;

import java.util.Arrays;

// TODO:- 
public class RotateArray {

    public void rotate(int[] nums, int k) {

        int start = 0;
        int curr = (start + k) % nums.length;
        int currNumber = nums[start];

        while (curr != start) {
            int temp = nums[curr];
            nums[curr] = currNumber;
            currNumber = temp;
            curr = (curr + k) % nums.length;
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(input, 3);
        Arrays.stream(input).forEach(System.out::println);
        System.out.println("Hello world");
    }

}
