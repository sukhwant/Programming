package mission.red.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class PermutationQuery {

    public int[] processQueries(int[] queries, int m) {

        List<Integer> inputs = new LinkedList<>();
        int[] result = new int[queries.length];

        for (int i = 1; i <= m; i++) {
            inputs.add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < inputs.size(); j++) {
                if(inputs.get(j) == queries[i]){
                    inputs.remove(j);
                    inputs.add(0, queries[i]);
                    break;
                }
                count++;
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {7,5,5,8,3};
        System.out.println(new PermutationQuery().processQueries(input, 8));
    }
}
