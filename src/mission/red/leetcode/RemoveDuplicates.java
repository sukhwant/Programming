package mission.red.leetcode;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
 * 
 * @author sukhwanp
 *
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] input) {

        if (input.length == 0) {
            return 0;
        }

        int currentIndex = 1;
        int currElement = input[0];

        for (int i = 1; i < input.length; i++) {
            if (input[i] != currElement) {
                input[currentIndex++] = input[i];
            }
            currElement = input[i];
        }
        return currentIndex;
    }

    public static void main(String[] args) {
        int[] input = {};
        int size = new RemoveDuplicates().removeDuplicates(input);
        System.out.println(size);

    }
}
