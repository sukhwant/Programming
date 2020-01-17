package mission.red.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Course2 {

    boolean cycle = false;
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    int[] visited = new int[10000];

    public static void main(String[] args) {
        int numCourse = 2;
        int[][] prerequisites = {{1, 0}, {1, 1}};
        System.out.println(new Course2().findOrder(numCourse, prerequisites));
    }

    void topologicalSort(Integer node) {
        if (cycle) {
            return;
        }
        visited[node] = 1;

        for (Integer neighbour : graph.getOrDefault(node, Collections.emptyList())) {
            int status = visited[neighbour];
            if (status == 0) {
                topologicalSort(neighbour);
            }
            if (status == 1) {
                cycle = true;
                return;
            }
        }
        visited[node] = 2;
        queue.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int[] prerequisite : prerequisites) {
            graph.computeIfAbsent(prerequisite[0], k -> new ArrayList<>()).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                topologicalSort(i);
            }
        }
        if (cycle) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        int k = 0;
        while (!queue.isEmpty()) {
            //System.out.println(queue.peek());
            result[k++] = queue.remove();
        }
        return result;
    }
}
