package mission.red.interviewbit;

import java.util.ArrayList;

public class MaximumAbsoluteDifference {

    public int maxArr(ArrayList<Integer> A) {

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, max4 = Integer.MIN_VALUE, ans = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE, min4 = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            max1 = Math.max(max1, A.get(i) + i);
            max2 = Math.max(max2, A.get(i) - i);
            max3 = Math.max(max3, -A.get(i) + i);
            max4 = Math.max(max4, -A.get(i) - i);

            min1 = Math.min(min1, A.get(i) + i);
            min2 = Math.min(min2, A.get(i) - i);
            min3 = Math.min(min3, -A.get(i) + i);
            min4 = Math.min(min4, -A.get(i) - i);

        }

        ans = Math.max(ans, max1 - min1);
        ans = Math.max(ans, max2 - min2);
        ans = Math.max(ans, max3 - min3);
        ans = Math.max(ans, max4 - min4);

        return ans;
    }

    public static void main(String[] args) {

        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(-1);

        System.out.println(new MaximumAbsoluteDifference().maxArr(input));
    }
}
