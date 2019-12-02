package mission.red.leetcode;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 * 
 * @author sukhwanp
 *
 */
public class NumArray {

    private int[] segmentTree;
    private int[] input;

    public NumArray(int[] input) {
        this.input = input;
        if (input.length > 0) {
            constructSegmentTree(input);
        }
    }

    private void constructSegmentTree(int[] input) {

        // Height
        int x = (int) (Math.ceil(Math.log(input.length) / Math.log(2)));

        // Size
        int max_size = 2 * (int) Math.pow(2, x) - 1;

        segmentTree = new int[max_size];

        constructSTUtil(input, 0, input.length - 1, 0);
    }

    private int constructSTUtil(int[] input, int start, int end, int currIndex) {

        if (start == end) {
            segmentTree[currIndex] = input[start];
        } else {
            int mid = (start + end) / 2;
            segmentTree[currIndex] = constructSTUtil(input, start, mid, 2 * currIndex + 1)
                    + constructSTUtil(input, mid + 1, end, 2 * currIndex + 2);

        }
        return segmentTree[currIndex];
    }

    public void update(int index, int value) {

        int diff = value - this.input[index];
        this.input[index] = value;

        updateUtil(0, this.input.length - 1, index, diff, 0);
    }

    private void updateUtil(int segmentStart, int segmentEnd, int index, int diff, int currNode) {
        if (index < segmentStart || index > segmentEnd)
            return;

        segmentTree[currNode] = segmentTree[currNode] + diff;
        if (segmentStart != segmentEnd) {
            int mid = (segmentStart + segmentEnd) / 2;
            updateUtil(segmentStart, mid, index, diff, 2 * currNode + 1); // Left Child
            updateUtil(mid + 1, segmentEnd, index, diff, 2 * currNode + 2); // Right Child
        }
    }

    public int sumRange(int queryStart, int queryEnd) {
        return getRangeSumUtil(0, input.length - 1, queryStart, queryEnd, 0);
    }

    private int getRangeSumUtil(int segmentStart, int segmentEnd, int queryStart, int queryEnd,
            int currIndex) {
        if (segmentStart >= queryStart && segmentEnd <= queryEnd) {
            return segmentTree[currIndex];
        } else if (segmentStart > queryEnd || segmentEnd < queryStart) {
            return 0;
        } else {
            int mid = (segmentStart + segmentEnd) / 2;
            return getRangeSumUtil(segmentStart, mid, queryStart, queryEnd, 2 * currIndex + 1)
                    + getRangeSumUtil(mid + 1, segmentEnd, queryStart, queryEnd, 2 * currIndex + 2);
        }
    }

    public static void main(String[] args) {
        int[] input = { 9, -8};
        NumArray obj = new NumArray(input);
        obj.update(0, 3);
        System.out.println(obj.sumRange(1, 1));
        System.out.println(obj.sumRange(0, 1));
        obj.update(1, -3);
        System.out.println(obj.sumRange(0, 1));
    }

}
