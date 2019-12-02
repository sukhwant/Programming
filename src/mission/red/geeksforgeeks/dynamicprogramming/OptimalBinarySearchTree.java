package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
 * 
 * @author sukhwanp
 *
 */
public class OptimalBinarySearchTree {

    public static void main(String[] args) {
        int[] input = { 10, 12, 20 };
        int[] frequency = { 34, 8, 50 };

        System.out.println(optimalBinaryTree(input, frequency));
    }

    private static int optimalBinaryTree(int[] input, int[] frequency) {

        int[][] cost = new int[input.length + 1][input.length + 1];

        for (int i = 0; i < input.length; i++) {
            cost[i][i] = frequency[i];
        }

        for (int length = 2; length <= input.length; length++) {
            for (int start = 0; start < input.length - length + 1; start++) {
                int end = start + length - 1;

                cost[start][end] = Integer.MAX_VALUE;

                for (int partition = start; partition <= end; partition++) {

                    int leftAns = (partition - 1 > start) ? cost[start][partition - 1] : 0;
                    int rightAns = (partition + 1 < end) ? cost[partition + 1][end] : 0;
                    cost[start][end] = Math.min(cost[start][end], leftAns + rightAns + frequency[partition]);
                }
            }
        }
        return cost[0][input.length - 1];
    }

}
