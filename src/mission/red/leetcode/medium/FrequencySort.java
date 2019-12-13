package mission.red.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class FrequencySort {

    public static void main(String[] args) {
        System.out.println(new FrequencySort().frequencySort("tree"));
    }

    // TODO:
    public String frequencySort(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            map.putIfAbsent(input.charAt(i), 0);
            map.computeIfPresent(input.charAt(i), (key, value) -> value + 1);
        }

        // sort the map
        LinkedHashMap<Character, Integer> sortedMap = map.entrySet()
            .stream()
            .sorted(Entry.comparingByValue())
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1,
                LinkedHashMap::new));

        StringBuilder stringBuilder = new StringBuilder();


        return stringBuilder.toString();
    }

}
