package mission.red.leetcode.challenge.september;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {

        Map<Character, String> charToString = new HashMap<>();
        Map<String, Character> stringToChar = new HashMap<>();

        String[] words = str.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if(!charToString.containsKey(pattern.charAt(i)) && (stringToChar.containsKey(words[i]))){
                return false;
            }
            if(charToString.containsKey(pattern.charAt(i)) && !(stringToChar.containsKey(words[i]))){
                return false;
            }

            if(!charToString.containsKey(pattern.charAt(i)) && !(stringToChar.containsKey(words[i]))){
                charToString.put(pattern.charAt(i), words[i]);
                stringToChar.put(words[i], pattern.charAt(i));
            }

            else if(charToString.containsKey(pattern.charAt(i)) && (stringToChar.containsKey(words[i]))){
                if(!charToString.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }
                if(stringToChar.get(words[i]) != pattern.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", str = "dog dog dog dog";
        System.out.println(new WordPattern().wordPattern(pattern, str));
    }
}
