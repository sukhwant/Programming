package mission.red.geeksforgeeks.easy;

/**
 * https://www.geeksforgeeks.org/program-to-find-the-hidden-number/
 * 
 * @author sukhwanp
 *
 */
public class FindHiddenNumber {

    public static void main(String[] args) {
        int[] input = { 1, 2, 3 };
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        if (sum % input.length == 0) {
            System.out.println(sum / input.length);
            return;
        }
        System.out.println("-1");
    }

}
