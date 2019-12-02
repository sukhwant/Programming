package javatutorial.datastructure;

public class Tester {

    public static void main(String[] args) {
        int[] input = { 1, 3, 5, 7, 9, 11 };

        SegmentTree segTree = new SegmentTree(input);
        System.out.println(segTree.getRangeSum(0, 5));
    }

}
