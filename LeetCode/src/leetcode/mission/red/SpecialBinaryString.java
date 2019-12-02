package leetcode.mission.red;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {

    public String makeLargestSpecial(String input) {

        List<String> result = new ArrayList<>();
        int count = 0;
        int start = 0;
        for (int end = 0; end < input.length(); end++) {
            if (input.charAt(end) == '1') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                result.add('1' + makeLargestSpecial(input.substring(start + 1, end)) + '0');
                start = end + 1;
            }
        }

        // Print collection
        // print(result);
        Collections.sort(result, Collections.reverseOrder());
        return String.join("", result);
    }

    private void print(List<String> result) {
        System.out.println("Priniting result");
        result.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        String input = "11011000";
        new SpecialBinaryString().makeLargestSpecial(input);
    }

}
