package mission.red.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {

        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
    }

    private void solve(char[] input, int start, List<String> result) {
        System.out.println("Start is: " + start);
        for (int i = start; i < input.length; i++) {
            if (Character.isDigit(input[i])) {
                continue;
            }

            if (Character.isLowerCase(input[i])) {
                input[i] = Character.toUpperCase(input[i]);
            } else {
                input[i] = Character.toLowerCase(input[i]);
            }

            result.add(new String(input));
            solve(input, i + 1, result);

            // Change... modify it back.
            if (Character.isLowerCase(input[i])) {
                input[i] = Character.toUpperCase(input[i]);
            } else {
                input[i] = Character.toLowerCase(input[i]);
            }

        }
    }

    public List<String> letterCasePermutation(String input) {
        List<String> result = new LinkedList<>();
        solve(input.toCharArray(), 0, result);
        result.add(input);
        return result;
    }
}
