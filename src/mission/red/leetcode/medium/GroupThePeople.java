package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 */
public class GroupThePeople {

    /**
     * Two iterations - one to create the map. The second one to iterate over map to get the
     * partitions.
     *
     * @param groupSizes
     * @return
     */
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (!groupMap.containsKey(groupSizes[i])) {
                groupMap.put(groupSizes[i], new LinkedList<Integer>());
            }
            groupMap.get(groupSizes[i]).add(i);
        }

        for (Entry<Integer, List<Integer>> entry : groupMap.entrySet()) {
            int key = entry.getKey();
            List<Integer> ids = entry.getValue();
            AtomicInteger counter = new AtomicInteger();

            final Collection<List<Integer>> groups = ids.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / key))
                .values();

            result.addAll(groups);
        }

        return result;
    }

    /**
     * Create result in same iteration.
     *
     * @param groupSizes
     * @return
     */
    public static List<List<Integer>> groupThePeopleOneIteration(int[] groupSizes) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (!groupMap.containsKey(groupSizes[i])) {
                groupMap.put(groupSizes[i], new LinkedList<Integer>());
            }
            groupMap.get(groupSizes[i]).add(i);

            if(groupMap.get(groupSizes[i]).size() == groupSizes[i]){
                result.add(groupMap.get(groupSizes[i]));

                // clear the map
                groupMap.put(groupSizes[i], new LinkedList<Integer>());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] groupSize = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(groupSize));
    }
}
