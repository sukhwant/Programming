package leetcode.mission.red;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        int smallestLength = findSmallestString(strs);
        
        StringBuilder strBuilder = new StringBuilder();
        if (strs.length == 0 || smallestLength == 0) {
            return strBuilder.toString();
        }
        for (int i = 0; i < smallestLength; i++) {
            char currentChar = strs[0].charAt(i);
            boolean isSame = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentChar) {
                    isSame = false;
                }
            }
            if (!isSame) {
                return strBuilder.toString();
            } else {
                strBuilder.append(currentChar);
            }
        }
        return strBuilder.toString();
    }

    private int findSmallestString(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }
        return min;
    }

    public static void main(String[] args) {
        String[] input = {};

        System.out.println(new LongestCommonPrefix().longestCommonPrefix(input));


    }

}
