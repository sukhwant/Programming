package mission.red.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal
 */
public class FractionToDecimal {

    public static void main(String[] args) {
        long numerator = -2147483648;
        long denominator = 1;
        System.out.println(new FractionToDecimal().fractionToDecimal(numerator, denominator));
    }

    public String fractionToDecimal(long numerator, long denominator) {

        StringBuilder stringBuilder = new StringBuilder();
        Map<Long, Integer> remainders = new HashMap<>();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            stringBuilder.append("-");
        }
        numerator = numerator < 0 ? numerator * -1 : numerator;
        denominator = denominator < 0 ? denominator * -1 : denominator;

        stringBuilder.append(numerator / denominator);
        numerator = numerator % denominator;
        boolean terminating = true;
        int recurringStartIndex = -1;
        int index = 0;
        if (numerator != 0) {
            stringBuilder.append(".");
        }
        while (numerator != 0) {
            long currRem = numerator;

            if (remainders.containsKey(currRem)) {
                terminating = false;
                recurringStartIndex = remainders.get(currRem);
                break;
            }

            long newRem = numerator * 10 % denominator;
            long quotient = numerator * 10 / denominator;

            remainders.put(currRem, index);
            stringBuilder.append(quotient);
            numerator = newRem;
            index++;

        }

        if (!terminating) {
            stringBuilder.insert(stringBuilder.indexOf(".") + recurringStartIndex + 1, "(");
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }
}
