package mission.red.codeforces;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SwapPermutation {

    public static void main(String[] args) {


        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();

        a.addAll(b);
        a.addAll(null);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int des = sc.nextInt();

            List<Integer> adjListSrc = graph.getOrDefault(src, new LinkedList<>());
            adjListSrc.add(des);
            graph.put(src, adjListSrc);

            List<Integer> adjListDes = graph.getOrDefault(des, new LinkedList<>());
            adjListDes.add(src);
            graph.put(src, adjListDes);
        }

        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, input, visited, i, new Result(input[i], i));

                //input[resul]
            }
        }
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int[] input, boolean[] visited,
        int root, Result result) {

        visited[root] = true;
        List<Integer> neighbours = graph.get(root);
        for (Integer neighbour : neighbours) {
            result.largestValue = Math.max(result.largestValue, input[neighbour]);
            result.smallestIndex = Math.min(result.smallestIndex, neighbour);
            dfs(graph, input, visited, neighbour, result);
        }
    }

    private static class Result {

        int largestValue;
        int smallestIndex;

        public Result(final int largestValue, final int smallestIndex) {
            this.largestValue = largestValue;
            this.smallestIndex = smallestIndex;
        }
    }
}
