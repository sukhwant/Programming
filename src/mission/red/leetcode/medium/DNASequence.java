package mission.red.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/repeated-dna-sequences
 */
public class DNASequence {

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(new DNASequence().findRepeatedDnaSequences(s));

    }

    public List<String> findRepeatedDnaSequences(String sequence) {

        Map<String, Integer> dnaMap = new HashMap<>();
        for (int i = 0; i <= sequence.length() - 10; i++) {
            String sub = sequence.substring(i, i + 10);
            dnaMap.put(sub, dnaMap.getOrDefault(sub, 0) + 1);
        }

        return dnaMap.entrySet()
            .stream()
            .filter(e -> e.getValue() > 1)
            .map(Entry::getKey)
            .collect(Collectors.toList());
    }
}
