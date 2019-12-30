package mission.red.leetcode.medium;

public class LongestMountain {

    public static void main(String[] args) {
        int[] input = {0, 0, 1, 0, 0, 1, 1, 1, 1, 1};
        System.out.println(new LongestMountain().longestMountain(input));
    }

    public int longestMountain(int[] input) {
        int start = 0;
        int maxHeight = 0;

        boolean up = false;
        boolean down = false;

        int curr = 1;
        while (curr < input.length) {
            if (input[curr] > input[curr - 1]) {
                up = true;
                if (down) {
                    maxHeight = Math.max(maxHeight, curr - start);
                    start = curr - 1;
                    down = false;
                }
            } else if (input[curr] < input[curr - 1]) {
                if (up && (curr == input.length - 1)) {
                    maxHeight = Math.max(maxHeight, curr - start + 1);
                } else if (up) {
                    down = true;
                } else {
                    start = curr;
                }
            } else {
                if (down) {
                    maxHeight = Math.max(maxHeight, curr - start);
                }
                start = curr;
                up = false;
                down = false;
            }
            curr++;
        }
        return maxHeight;
    }
}
