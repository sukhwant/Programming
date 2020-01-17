package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    List<List<Integer>> result = new ArrayList<>();
    int N;
    int totalK;

    public static void main(String[] args) {
        System.out.println(new Combination().combine(4, 2));
    }

    void backtrack(int currK, int currN, List<Integer> currSequence) {

        if (currK >= totalK) {
            result.add(new ArrayList<>(currSequence));
            return;
        }

        for (int i = currN; i <= N; i++) {
            currSequence.add(i);
            backtrack(currK + 1, i + 1, currSequence);
            currSequence.remove(currSequence.size() - 1);
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        N = n;
        totalK = k;
        backtrack(0, 1, new ArrayList<Integer>());
        return result;
    }

}
