package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {


    public boolean wordBreak(String s, List<String> wordDict) {
        return result(s, wordDict, new HashMap<String, Boolean>());
    }

    private boolean result(final String s, final List<String> wordDict, HashMap<String,
        Boolean> memory) {

        if(s.equals(""))
            return true;
        if(memory.containsKey(s))
            return memory.get(s);

        for(String word: wordDict){
            if(s.startsWith(word)){
                boolean remaining = result(s.substring(word.length()), wordDict, memory);
                if(remaining){
                    memory.put(s.substring(word.length()), true);
                    return true;
                }
            }
        }
        memory.put(s, false);
        return false;

    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
//        dict.add("sand");
//        dict.add("and");
//        dict.add("cat");
        System.out.println(new WordBreak().wordBreak("leetcode",dict));
    }
}
