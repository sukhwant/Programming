package mission.red.leetcode.easy;

public class ReverseString {

    public void reverseString(char[] s) {

        for (int i = 0; i < s.length/2; i++) {
            //swap
            char temp = s[s.length - i - 1];
            s[s.length - i - 1] = s[i];
            s[i] = temp;
        }
    }

    public static void main(String[] args) {
        char[] input = {'s','u','k','h','w','a'};
        new ReverseString().reverseString(input);
        System.out.println();
    }
}
