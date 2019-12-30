package mission.red.codeforces;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * https://codeforces.com/problemset/problem/274/B
 */
public class Zerotree {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i < n; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();

            tree.putIfAbsent(src, new LinkedList<>());
            tree.putIfAbsent(dest, new LinkedList<>());

            tree.get(src).add(dest);
            tree.get(dest).add(src);
        }

        long[] weight = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = scanner.nextInt();
        }

        boolean[] seen = new boolean[n + 1];
        long[] increment = new long[n + 1];
        long[] decrement = new long[n + 1];

        dfs(1, tree, seen, increment, decrement, weight);
        System.out.println(increment[1] + decrement[1]);
    }

    private static void dfs(Integer start, Map<Integer, List<Integer>> tree, boolean[] visited,
        long[] increment, long[] decrement, long[] weight) {
        if (visited[start]) {
            return;
        }

        visited[start] = true;

        for (Integer node : tree.get(start)) {
            if (visited[node]) {
                continue;
            }
            dfs(node, tree, visited, increment, decrement, weight);
            increment[start] = Math.max(increment[start], increment[node]);
            decrement[start] = Math.max(decrement[start], decrement[node]);
        }

        weight[start] = weight[start] + increment[start] - decrement[start];
        if (weight[start] > 0) {
            decrement[start] += weight[start];
        } else if (weight[start] < 0) {
            increment[start] -= weight[start];
        }
    }
}
