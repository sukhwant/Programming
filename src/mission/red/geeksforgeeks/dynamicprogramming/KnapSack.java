package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * 
 * 
 * @author sukhwanp
 *
 */
public class KnapSack {

    private static class Item {
        int value;
        int weight;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    private static int knapsack(Item[] items, int capacity) {
        int[][] table = new int[items.length + 1][capacity + 1];

        for (int i = 0; i <= items.length; i++) {
            for (int weight = 0; weight <= capacity; weight++) {
                if (weight == 0 || i == 0) {
                    table[i][weight] = 0;
                } else if (items[i - 1].weight <= weight) {
                    table[i][weight] = Math.max(table[i - 1][weight],
                            items[i - 1].value + table[i - 1][weight - items[i - 1].weight]);
                } else {
                    table[i][weight] = table[i - 1][weight];
                }
            }
        }
        return table[items.length][capacity];
    }

    public static void main(String[] args) {
        Item[] items = new Item[3];
        items[0] = new Item(10, 60);
        items[1] = new Item(20, 100);
        items[2] = new Item(30, 120);

        int capacity = 50;

        System.out.println(knapsack(items, capacity));
    }

}
