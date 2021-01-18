package mission.red.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public class Element{
        public char ch;
        public int position;

        public Element(final char ch, final int position) {
            this.ch = ch;
            this.position = position;
        }
    }

    public String minWindow(String s, String t) {

        int start = 0, end = 0;
        int minStart = 0, minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        boolean flag = false;
        boolean firstChar = false;
        Queue<Element> queue = new LinkedList<>();
        Map<Character, Integer> foundChars = new HashMap<>();

        HashMap<Character,Integer> charFreqMap = new HashMap<>();
        for(int i= 0 ; i< t.length() ; i++) {
            Character ch=t.charAt(i);
            charFreqMap.computeIfPresent(ch, (character,count)-> count+1);
            charFreqMap.computeIfAbsent(ch, (character)-> 1);
        }

        while(end < s.length()){
            if(charFreqMap.containsKey(s.charAt(end))){
                if(!firstChar){
                    start = end;
                    firstChar = true;
                }
                queue.add(new Element(s.charAt(end), end));
                foundChars.compute(s.charAt(end), (k, v) -> (v == null) ? 1 : v+1);
            }

            while(checkEquality(foundChars, charFreqMap)){
                // Found one window.... - [start, end]
                flag = true;
                int tempLength = end - start;
                System.out.println("Found one subString, Start: " + start + " End: " + end);
                if(tempLength < minLength){
                    minLength = tempLength;
                    minStart = start;
                    minEnd = end;
                }

                Character temp = queue.poll().ch;
                if(foundChars.get(temp) == 1){
                    foundChars.remove(temp);
                } else{
                    foundChars.compute(temp, (k, v) -> v-1);
                }
                if(!queue.isEmpty()) {
                    start = queue.peek().position;
                }
            }
            end++;
            if(queue.isEmpty()){
                firstChar = false;
            }
        }

        if(flag)
            return s.substring(minStart, minEnd + 1);
        return "";
    }

    private boolean checkEquality(final Map<Character, Integer> foundChars, final HashMap<Character, Integer> charFreqMap) {
        if(foundChars.size() != charFreqMap.size()){
            return false;
        }
        
        for(Character c: foundChars.keySet()){
            if(foundChars.get(c) < charFreqMap.get(c)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ABC", t = "BC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }
}
