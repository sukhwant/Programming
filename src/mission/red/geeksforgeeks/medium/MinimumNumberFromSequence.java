package mission.red.geeksforgeeks.medium;

/**
 * https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
 * 
 * @author sukhwanp
 *
 */
public class MinimumNumberFromSequence {

    public static void main(String[] args) {

        String input = "DDIDDIID";
        System.out.println(minimumNumber(input));

    }

    private static char[] minimumNumber(String input) {
        int currNumber = 1;
        int[] result = new int[input.length() + 1];

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'I') {

                // FInd next D's
                int j = i + 1;
                int dCount = 0;
                while (input.charAt(j) == 'D') {
                    dCount += 1;
                    j++;
                }
                result[i] = currNumber + dCount + 1;
            } else {

                // FInd next D's
                int j = i + 1;
                int dCount = 0;
                while (input.charAt(j) == 'D') {
                    dCount += 1;
                    j++;
                }
                result[i] = currNumber + dCount + 1;
            }
        }
        return null;
    }
}
