package mission.red.geeksforgeeks.dynamicprogramming;

public class RodCutting {

    private static int rodCutting(int[] price, int rodLength) {

        int[] ans = new int[rodLength + 1];
        ans[0] = 0;
        ans[1] = price[1];

        for (int size = 2; size <= rodLength; size++) {
            // ans[size] = ans[]
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
