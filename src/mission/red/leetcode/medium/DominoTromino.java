package mission.red.leetcode.medium;

public class DominoTromino {

    public int numTilings(int N) {

        int[] ans = new int[1001];
        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 5;

        for (int i = 4; i <= N; i++) {
            ans[i] = 2*ans[i-1] + ans[i-3];
            System.out.println("Ans: " + i + "is: " + ans[i]);
        }
        return ans[N];
    }

    public static void main(String[] args) {
        System.out.println(new DominoTromino().numTilings(4));
    }
}
