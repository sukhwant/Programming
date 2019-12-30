package mission.red.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {

        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
    }

    private void solve(String input, int start, int end, List<String> result) {

        if (end == input.length()) {

        }
    }

    public List<String> letterCasePermutation(String input) {
        List<String> result = new LinkedList<>();
        solve(input, 0, input.length(), result);
        return result;
    }
}
