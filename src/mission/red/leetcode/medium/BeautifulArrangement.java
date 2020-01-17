package mission.red.leetcode.medium;

public class BeautifulArrangement {

    int found = 0;
    boolean[] visited = new boolean[20];

    public static void main(String[] args) {
        System.out.println(new BeautifulArrangement().countArrangement(3));
    }

    void backtrack(int currN, int totalN) {

        if (currN > totalN) {
            found++;
            return;
        }

        for (int i = 1; i <= totalN; i++) {
            if (!visited[i] && (currN % i == 0 || i % currN == 0)) {
                visited[i] = true;
                backtrack(currN + 1, totalN);
                visited[i] = false;
            }
        }
    }

    public int countArrangement(int N) {
        backtrack(1, N);
        return found;
    }
}
