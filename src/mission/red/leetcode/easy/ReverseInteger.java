package mission.red.leetcode.easy;

public class ReverseInteger {

    public int reverse(int x) {
        int num = x;
        int rev = 0;
        while(num != 0){
            int currRev = rev*10 + num % 10;
            if((currRev - num%10)/10 != rev){
                return 0;
            }
            num = num/10;
            rev = currRev;
        }

        return rev;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-123456));
    }
}
