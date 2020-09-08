package mission.red.leetcode.medium;


public class PlusOne {

    public int[] plusOne(int[] digits) {

        int curr = digits.length - 1;
        while(curr >= 0){
            if(digits[curr] < 9){
                digits[curr] = digits[curr] + 1;
                return digits;
            } else {
                digits[curr] = 0;
                curr--;
            }
        }
        if(curr < 0){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] digits = {9};
        System.out.println(new PlusOne().plusOne(digits));
    }
}
