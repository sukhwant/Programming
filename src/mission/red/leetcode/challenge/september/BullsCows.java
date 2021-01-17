package mission.red.leetcode.challenge.september;

import java.util.HashMap;
import java.util.Map;

public class BullsCows {


    public String getHint(String secret, String guess) {

        Map<Character, Integer> workMap = new HashMap<>();

        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            } else {
                workMap.compute(secret.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            }
        }
        // Caclculate cows

        for (int i = 0; i < guess.length(); i++) {
            if(secret.charAt(i) != guess.charAt(i)) {
                // check if it is cow.
                if(workMap.containsKey(guess.charAt(i)) && workMap.get(guess.charAt(i)) > 0){
                    cows++;
                    workMap.compute(guess.charAt(i), (k, v) -> v - 1);
                }
            }
        }

        System.out.println("Bulls " + bulls + " cows " + cows);

        return "" + bulls + "A" + cows + "B";

    }

    public static void main(String[] args) {

        System.out.println(new BullsCows().getHint("1122","1222"));
    }
}
