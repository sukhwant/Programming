package mission.red.leetcode.medium;

public class Jump {

    public static void main(String[] args) {
        int[] input = {3, 0, 2, 1, 2};
        int start = 2;
        System.out.println(new Jump().canReach(input, start));
    }

    private boolean bfs(int[] input, int index, boolean[] visited) {

        int leftNeighbour = index + input[index];
        int rightNeighbour = index - input[index];
        boolean leftResult = false;
        boolean rightResult = false;

        if (leftNeighbour >= 0 && leftNeighbour < input.length && !visited[leftNeighbour]) {
            if (input[leftNeighbour] == 0) {
                return true;
            }
            visited[leftNeighbour] = true;
            leftResult = bfs(input, leftNeighbour, visited);
        }
        if (rightNeighbour >= 0 && rightNeighbour < input.length && !visited[rightNeighbour]) {
            if (input[rightNeighbour] == 0) {
                return true;
            }
            visited[rightNeighbour] = true;
            rightResult = bfs(input, rightNeighbour, visited);
        }
        return leftResult || rightResult;
    }

    public boolean canReach(int[] input, int start) {
        boolean[] visited = new boolean[input.length];
        return bfs(input, start, visited);
    }
}
