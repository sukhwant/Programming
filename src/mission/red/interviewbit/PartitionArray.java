package mission.red.interviewbit;

import java.util.ArrayList;

public class PartitionArray {

    int numberOfWays = 0;

    private void helper(int start, int count, ArrayList<Integer> B, int sum) {

        if (count > 3) {
            return;
        }
        if (start > B.size()) {
            return;
        }
        if(count == 3 && start == B.size()){
            numberOfWays += 1;
        }

        int tempSum = 0;
        for (int i = start; i < B.size(); i++) {
            tempSum += B.get(i);

            if(tempSum == sum){
                helper(i+1, count+1, B, sum);
            }
        }
    }

    public int solve(int A, ArrayList<Integer> B) {
        numberOfWays = 0;
        int allSum = B.stream().mapToInt(Integer::valueOf).sum();
        if(allSum % 3 != 0){
            return 0;
        }
        helper(0, 0, B, allSum/3);
        return numberOfWays;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(0);
        input.add(3);

        System.out.println(new PartitionArray().solve(input.size(), input));
    }
}
