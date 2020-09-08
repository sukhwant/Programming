package mission.red.leetcode.challenge.september;

import java.util.Collections;

public class RepeatingSubstring {

    public boolean repeatedSubstringPattern(String s) {
        int times = 2;
        while(times <= s.length()){
            if(s.length()%times == 0 && s.equals(String.join("", Collections.nCopies(times,
                s.substring(0, s.length()/times))))){
                return true;
            }
            times++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatingSubstring().repeatedSubstringPattern("aba"));
    }

}
