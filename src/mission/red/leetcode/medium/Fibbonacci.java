package mission.red.leetcode.medium;

public class Fibbonacci {

    public int fib(int N) {
        int[] result = new int[N+1];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= N; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[N];
    }

    public static void main(String[] args) {

    }
}
