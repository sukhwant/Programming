package mission.red.leetcode.challenge.feburary;

import java.util.Arrays;

public class ShortestDistance {

    public int[] shortestToChar(String s, char c) {

        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        int[] answer = new int[s.length()];

        int prev = Integer.MIN_VALUE/2;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            left[i] = i - prev;
        }

        prev = Integer.MAX_VALUE/2;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            right[i] = prev - i;
        }

        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(left));
        for (int i = 0; i < s.length(); i++) {
            answer[i] = Math.min(left[i], right[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
            Arrays.toString(new ShortestDistance().shortestToChar("loveleetcode", 'e')));
    }
}
