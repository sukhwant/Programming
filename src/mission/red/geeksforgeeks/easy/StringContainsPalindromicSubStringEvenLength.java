package mission.red.geeksforgeeks.easy;

/**
 * 
 * @author sukhwanp
 *         https://www.geeksforgeeks.org/check-if-a-string-contains-a-palindromic-sub-string-of-even-length/
 * 
 */
public class StringContainsPalindromicSubStringEvenLength {

    public static void main(String[] args) {
        String input = "dasgkzfhjlkssdkal";

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                System.out.println("YES!!!");
                return;
            }
        }
        System.out.println("NO!!!!");
    }

}
