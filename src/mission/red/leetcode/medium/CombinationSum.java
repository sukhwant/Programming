package mission.red.leetcode.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CombinationSum {

    public static void main(String[] args) {
        int[] input = {2, 3, 6, 7};
        int target = 7;

        System.out.println(new CombinationSum().combinationSum(input, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Map<Integer, Set<List<Integer>>> resultMap = new HashMap<>();
        resultMap.put(0, new HashSet<>());
        for (int i = 1; i <= target; i++) {
            Set<List<Integer>> currTargetResult = new HashSet<>();
            for (int j = 0; j < candidates.length; j++) {
                if (i > candidates[j]) {
                    //include in answer.
                    Set<List<Integer>> currResult = resultMap.get(i - candidates[j]);
                    if (currResult != null) {
                        for (List<Integer> currList : currResult) {
                            List<Integer> temp = new LinkedList<>(currList);
                            temp.add(candidates[j]);
                            Collections.sort(temp);
                            currTargetResult.add(temp);
                        }
                    }
                } else if (i == candidates[j]) {
                    //include in answer.
                    List<Integer> temp = new LinkedList<>();
                    temp.add(candidates[j]);
                    currTargetResult.add(temp);
                }
            }
            //System.out.println("currtarget: " + i + currTargetResult);
            resultMap.put(i, currTargetResult);
        }

        //System.out.println(resultMap);
        return new LinkedList<>(resultMap.get(target));
    }
}
