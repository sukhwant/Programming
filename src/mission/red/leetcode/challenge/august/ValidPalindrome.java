package mission.red.leetcode.challenge.august;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String input = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverse = new StringBuilder(input).reverse().toString();
        return input.equals(reverse);
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("race a car"));
    }
}
