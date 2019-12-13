package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows
 */
public class FlipColumns {

    public static void main(String[] args) {
        int[][] input = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(new FlipColumns().maxEqualRowsAfterFlips(input));
    }

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> rowMap = new HashMap<>();

        Arrays.stream(matrix)
            .map(Arrays::toString)
            .forEach(x -> rowMap.put(x, rowMap.getOrDefault(x, 0) + 1));

        Optional<Integer> maxRowsCount = rowMap.entrySet().stream()
            .map(x -> x.getValue() + rowMap.getOrDefault(negate(x.getKey()), 0))
            .max(Integer::compare);
        return maxRowsCount.get();
    }

    private String negate(final String x) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '0') {
                stringBuilder.append('1');
            } else if (x.charAt(i) == '1') {
                stringBuilder.append('0');
            } else {
                stringBuilder.append(x.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
