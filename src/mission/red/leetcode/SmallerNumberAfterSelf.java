package mission.red.leetcode;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 
 * Solution using Fenwick tree.
 * 
 * @author sukhwanp
 *
 */
public class SmallerNumberAfterSelf {

    private int[] tree;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = (nums[i] < min) ? nums[i] : min;
        }
        int[] input = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            input[i] = nums[i] - min + 1;
            max = Math.max(input[i], max);
        }
        this.tree = new int[max + 1];
        for (int i = input.length - 1; i >= 0; i--) {
            result.add(0, get(input[i] - 1));
            update(input[i]);
            //printResult(result);
            //printTree();
        }
        return result;
    }

    private void printResult(List<Integer> result) {
        System.out.print("Result is:- ");
        result.stream().forEach(x -> System.out.print(x + "  "));
        System.out.println();
    }

    private void printTree() {
        System.out.print("Tree is:- ");
        for (int i = 0; i < this.tree.length; i++) {
            System.out.print(this.tree[i] + "  ");
        }
        System.out.println();
    }

    private int get(int i) {
        int num = 0;
        while (i > 0) {
            num += this.tree[i];
            i -= i & (-i);
        }
        return num;
    }

    private void update(int i) {
        while (i < this.tree.length) {
            this.tree[i]++;
            i += i & (-i);
        }
    }

    public static void main(String[] args) {
        int[] input = { 5, 2, 6, 1 };
        new SmallerNumberAfterSelf().countSmaller(input);
    }
}
