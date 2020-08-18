package mission.red.leetcode.challenge.august;

public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        int curr = 1;
        while(curr <= num){
            if(curr == num) {
                return true;
            } else{
                curr = curr * 4;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfFour().isPowerOfFour(1162261466));
    }
}
