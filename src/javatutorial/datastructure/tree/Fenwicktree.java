package javatutorial.datastructure.tree;

public class Fenwicktree {

    int[] tree;
    int size;

    public void Fenwicktree(int[] input) {
        constructFenwickTree(input);
    }

    private void constructFenwickTree(int[] input) {
        this.tree = new int[input.length + 1];
        this.size = input.length;

        this.tree[0] = 0;
        for (int i = 1; i <= input.length; i++) {
            updateTree(i, input[i - 1]);
        }

    }

    public void updateTree(int index, int value) {
        this.tree[index] += value;
        while (index < size) {
            updateTree(index, value);
            index = getNext(index);
        }
    }

    private int getPrefixSum(int index) {
        int sum = 0;
        while (index < 0) {
            sum += this.tree[index];
            index = getParent(index);
        }
        return sum;
    }

    public int getSum(int startRange, int endRange) {
        return getPrefixSum(endRange) - getPrefixSum(startRange);
    }

    private int getParent(int nodeId) {
        return nodeId - (nodeId & -nodeId);
    }

    private int getNext(int nodeId) {
        return nodeId + (nodeId & -nodeId);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
