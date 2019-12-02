package mission.red.geeksforgeeks.medium;

public class SplitWise {

    public static void main(String[] args) {
        int graph[][] = { { 0, 1000, 2000 }, { 0, 0, 5000 }, { 0, 0, 0 }, };

        // Print the solution
        minCashFlow(graph);
    }

    private static void minCashFlow(int[][] graph) {

        int[] amount = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                amount[i] += graph[i][j] - graph[j][i];
            }
        }

        minCashFlowRec(amount);
    }

    private static void minCashFlowRec(int[] amount) {
        int maxCredit = getMax(amount);
        int maxDebit = getMin(amount);

        if (maxDebit == 0 && maxCredit == 0) {
            System.out.println("Done....");
            return;
        }

        int min = Math.min(-amount[maxDebit], amount[maxCredit]);
        amount[maxCredit] -= min;
        amount[maxDebit] += min;

        System.out.println("Person " + maxCredit + " pays " + min + " to " + "Person " + maxDebit);

        minCashFlowRec(amount);
    }

    private static int getMin(int[] amount) {
        int minInd = 0;
        for (int i = 1; i < amount.length; i++) {
            if (amount[i] < amount[minInd]) {
                minInd = i;
            }
        }
        return minInd;
    }

    private static int getMax(int[] amount) {
        int maxInd = 0;
        for (int i = 1; i < amount.length; i++) {
            if (amount[i] > amount[maxInd]) {
                maxInd = i;
            }
        }
        return maxInd;
    }

}
