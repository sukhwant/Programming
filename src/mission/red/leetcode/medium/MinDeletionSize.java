package mission.red.leetcode.medium;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 */
public class MinDeletionSize {

    public static void main(String[] args) {
        String[] input = {"ca", "bb", "ac"};
        System.out.println(new MinDeletionSize().minDeletionSize(input));
    }

    /**
     * Greedy Approach. Check each column at a time and see if it can be included or not.
     *
     * @param input
     * @return
     */
    public int minDeletionSize(String[] input) {

        if (input.length == 0) {
            return 0;
        }

        int stringSize = input[0].length();
        int numberOfStrings = input.length;

        boolean[] isSorted = new boolean[numberOfStrings];
        int numberOfSortedElement = 1;
        int deleteCount = 0;

        for (int charIndex = 0; charIndex < stringSize; charIndex++) {

            int stringIndex = 0;
            for (stringIndex = 0; stringIndex < numberOfStrings - 1; stringIndex++) {
                if (!isSorted[stringIndex] && (input[stringIndex].charAt(charIndex) > input[
                    stringIndex + 1].charAt(charIndex))) {
                    // Not sorted, delete the column....
                    deleteCount++;
                    break;
                }
            }

            if (stringIndex < numberOfStrings - 1) {
                continue;
            }

            for (stringIndex = 0; stringIndex < numberOfStrings - 1; stringIndex++) {
                if (!isSorted[stringIndex] && (input[stringIndex].charAt(charIndex) < input[
                    stringIndex + 1].charAt(charIndex))) {
                    // sorted, mark the string as sorted
                    isSorted[stringIndex] = true;
                    numberOfSortedElement++;
                }
            }

            if (numberOfSortedElement == stringSize) {
                return deleteCount;
            }
        }

        return deleteCount;
    }
}
