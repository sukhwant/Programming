package mission.red.interviewbit;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {

    public int majorityElement(final List<Integer> A) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer element : A) {
            countMap.compute(element, (k, v) -> (v == null) ? 1 : v + 1);
        }

        return Collections.max(countMap.entrySet(),
            Comparator.comparingInt(Entry::getValue)).getKey();
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(Arrays.asList(2, 1, 2)));
    }
}
