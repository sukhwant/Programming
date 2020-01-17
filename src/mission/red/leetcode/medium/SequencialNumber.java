package mission.red.leetcode.medium;

public class SequencialNumber {

    public static void main(String[] args) {
        System.out.println(new SequencialNumber().countNumbersWithUniqueDigits(2));
    }

    public int countNumbersWithUniqueDigits(int n) {
        int sum = 0;
        for (int i = 0; i < n - 1 && i < 9; i++) {
            int product = 9;
            for (int j = 9 - i; j <= 9; j++) {
                product = product * j;
            }
            System.out.println(product);
            sum += product;
        }
        return sum + 10;
    }
}
