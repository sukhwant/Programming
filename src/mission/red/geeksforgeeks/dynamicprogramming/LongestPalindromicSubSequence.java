package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
 * 
 * @author sukhwanp
 *
 */

public class LongestPalindromicSubSequence {

    public class Data{
        public int length;
        public int start;
    }

    private static int longestPalindromicSubSequenceRecursive(String input, int start, int end,
        int[][] result) {

        if(start > end){
            return 0;
        }

        if(result[start][end] != -1){
            return result[start][end];
        }

        if(start == end){
            return 1;
        }

        if(input.charAt(start) == input.charAt(end)){
            result[start][end] = longestPalindromicSubSequenceRecursive(input, start + 1, end - 1
                , result);
        } else{
            result[start][end] = Math.max(longestPalindromicSubSequenceRecursive(input, start + 1,
                end, result), longestPalindromicSubSequenceRecursive(input, start,
                end - 1, result));
        }
        return result[start][end];
    }



    public static void main(String[] args) {
        String input = "GEEKS FOR GEEKS";

        int[][] result = new int[input.length()][input.length()];

        System.out.println(longestPalindromicSubSequenceRecursive(input, 0, input.length(),
            result));
    }

}
