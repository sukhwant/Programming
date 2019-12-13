package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/top-k-frequent-elements
 */
public class KFrequentElement {

    public static void main(String[] args) {

        int[] input = {1};
        int k = 1;

        System.out.println(new KFrequentElement().topKFrequent(input, k));

    }

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Arrays.stream(nums)
            .forEach(x -> countMap.put(x, countMap.getOrDefault(x, 0) + 1));

        PriorityQueue<Nums> priorityQueue = new PriorityQueue<>(
            Comparator.comparingInt(Nums::getCount).reversed());

        countMap.entrySet().stream()
            .map(entry -> new Nums(entry.getKey(), entry.getValue()))
            .forEach(priorityQueue::add);

        return IntStream.range(0, k).mapToObj(x -> priorityQueue.poll().getNumber())
            .collect(Collectors.toList());
    }

    public class Nums {

        private Integer number;
        private Integer count;

        public Nums(final Integer number, final Integer count) {
            this.number = number;
            this.count = count;
        }

        public Integer getNumber() {
            return number;
        }

        public Integer getCount() {
            return count;
        }
    }

}
