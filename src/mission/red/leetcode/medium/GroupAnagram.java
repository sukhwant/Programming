package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            result.putIfAbsent(sorted, new LinkedList<>());
            result.get(sorted).add(str);
        }

        List<List<String>> ans = result.entrySet()
                                    .stream()
                                    .map(x -> x.getValue())
                                    .collect(Collectors.toList());
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        new GroupAnagram().groupAnagrams(strs);

    }
}
