package mission.red.geeksforgeeks.easy;

public class LongestSubArrayWithEvenNumbers {

    public static void main(String[] args) {

        int maxLength = 0;
        int currLength = 0;
        int[] input = { 9, 8, 5, 4, 4, 4, 2, 4, 1 };
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0) {
                currLength++;
            } else {
                currLength = 0;
            }
            if (maxLength < currLength) {
                maxLength = currLength;
            }
        }
        System.out.println(maxLength);
    }
}
