package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class EvaluateDivision {

    private boolean found = false;
    private double ans;
    private Map<String, List<Edge>> graph = new HashMap<>();

    public static void main(String[] args) {

        List<List<String>> equations = new LinkedList<>();
        equations.add(new LinkedList<>(Arrays.asList("a", "b")));
        equations.add(new LinkedList<>(Arrays.asList("b", "c")));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new LinkedList<>();//[ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
        queries.add(new LinkedList<>(Arrays.asList("a", "c")));
        queries.add(new LinkedList<>(Arrays.asList("b", "a")));
        queries.add(new LinkedList<>(Arrays.asList("a", "e")));
        queries.add(new LinkedList<>(Arrays.asList("a", "a")));
        queries.add(new LinkedList<>(Arrays.asList("x", "x")));

        System.out.println(new EvaluateDivision().calcEquation(equations, values, queries));

    }

    public void distance(String src, String dest, double currValue,
        Set<String> visited) {
        visited.add(src);
        if (src.equals(dest)) {
            found = true;
            ans = currValue;
            return;
        }

        for (Edge neighbour : graph.get(src)) {
            if (!visited.contains(neighbour.node) && !found) {
                distance(neighbour.node, dest, currValue * neighbour.value, visited);
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values,
        List<List<String>> queries) {

        // create map
        for (int i = 0; i < equations.size(); i++) {
            // put a/b
            List<Edge> neighbourA = graph.getOrDefault(equations.get(i).get(0),
                new LinkedList<>());
            neighbourA.add(new Edge(equations.get(i).get(1), values[i]));
            graph.put(equations.get(i).get(0), neighbourA);

            // put b/a
            List<Edge> neighbourB = graph.getOrDefault(equations.get(i).get(1),
                new LinkedList<>());
            neighbourB.add(new Edge(equations.get(i).get(0), 1 / values[i]));
            graph.put(equations.get(i).get(1), neighbourB);
        }

        double[] answers = new double[queries.size()];
        int k = 0;
        for (List<String> query : queries) {
            found = false;
            ans = -1;
            if (!graph.containsKey(query.get(0)) || !graph.containsKey(query.get(1))) {
                answers[k++] = -1;
            } else {
                distance(query.get(0), query.get(1), 1, new HashSet<>());
                answers[k++] = ans;
            }

        }
        return answers;
    }

    public class Edge {

        String node;
        double value;

        public Edge(final String node, final double value) {
            this.node = node;
            this.value = value;
        }
    }


}
