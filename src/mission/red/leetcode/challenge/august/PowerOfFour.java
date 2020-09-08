package mission.red.leetcode.challenge.august;

public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        return num !=0 && ((num & (num-1)) == 0) && ((num & 0xAAAAAAAA) == 0);
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfFour().isPowerOfFour(1162261466));
    }
}
