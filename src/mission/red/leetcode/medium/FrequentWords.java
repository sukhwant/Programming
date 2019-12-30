package mission.red.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/top-k-frequent-words
 */
public class FrequentWords {

    public static void main(String[] args) {
        String[] input = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(new FrequentWords().topKFrequent(input, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.putIfAbsent(word, 0);
            map.computeIfPresent(word, (key, value) -> value + 1);
        }

        return map.entrySet()
            .stream()
            .sorted((e1, e2) -> {
                if (!e2.getValue().equals(e1.getValue())) {
                    return e2.getValue() - e1.getValue();
                } else {
                    return e1.getKey().compareTo(e2.getKey());
                }
            })
            .map(Map.Entry::getKey)
            .limit(k)
            .collect(Collectors.toList());
    }
}
