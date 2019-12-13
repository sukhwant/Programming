package mission.red.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/largest-values-from-labels/
 */
public class LargestValueFromlabel {

    public static void main(String[] args) {

        int[] values = {9,8,8,7,6};
        int[] labels = {0,0,0,1,1};
        int num_wanted = 3;
        int use_limit = 1;

        System.out.println(new LargestValueFromlabel().largestValsFromLabels(values, labels,
            num_wanted, use_limit));

        System.out.println("Hello");

    }

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

        List<Item> items = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            items.add(new Item(values[i], labels[i]));
        }

        items.sort((x, y) -> y.value - x.value);

        int currCount = 0;
        Map<Integer, Integer> labelCount = new HashMap<>();
        int currValue = 0;
        for (Item item : items) {
            labelCount.putIfAbsent(item.getLabel(), 0);
            if (labelCount.get(item.label) < use_limit) {
                //item taken
                currCount++;
                currValue += item.value;
                labelCount.compute(item.getLabel(), (key, value) -> value + 1);
            }
            if (currCount == num_wanted) {
                return currValue;
            }
        }
        return currValue;
    }

    public class Item {

        int value;
        int label;

        public Item(final int value, final int label) {
            this.value = value;
            this.label = label;
        }

        public int getValue() {
            return value;
        }

        public int getLabel() {
            return label;
        }
    }
}
