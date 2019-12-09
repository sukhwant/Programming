package mission.red.leetcode.easy;

public class Palindrome {

    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            rev = rev*10 + x % 10;
            x = x/10;
        }

        return rev;
    }

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        return x == reverse(x);
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome(121));
    }
}
