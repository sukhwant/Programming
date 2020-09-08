package mission.red.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class AlternatingColor {

    public class Edge{
        public Boolean isRed;
        public int dest;
        public int distance;

        public Edge(final Boolean isRed, final int dest, final int distance) {
            this.isRed = isRed;
            this.dest = dest;
            this.distance = distance;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {

        Queue<Edge> queue = new LinkedList<>();

        int[] distance = new int[n];
        boolean[] redVisited = new boolean[n];
        boolean[] blueVisited = new boolean[n];

        Arrays.fill(distance, -1);

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < red_edges.length; i++) {
            graph.putIfAbsent(red_edges[i][0], new LinkedList<>());
            graph.get(red_edges[i][0]).add(new Edge(true, red_edges[i][1], 1));
        }

        for (int i = 0; i < blue_edges.length; i++) {
            graph.putIfAbsent(blue_edges[i][0], new LinkedList<>());
            graph.get(blue_edges[i][0]).add(new Edge(false, blue_edges[i][1], 1));
        }

        queue.add(new Edge(null, 0, 0));

        while(!queue.isEmpty()){

            Edge curr = queue.remove();
            if(curr.isRed != null) {
                if (curr.isRed)
                    redVisited[curr.dest] = true;
                if (!curr.isRed)
                    blueVisited[curr.dest] = true;
            }
            System.out.println("Current Node: " + curr.dest + " With Distance: " + curr.distance + "color: " + curr.isRed);
            distance[curr.dest] = curr.distance;

            if(graph.containsKey(curr.dest)) {
                for (Edge edge : graph.get(curr.dest)) {
                    System.out.println("Neighbour Node: " + edge.dest + " With Distance: " + edge.distance + "color: " + edge.isRed);
                    if ((curr.isRed == null) ||
                        (edge.isRed == false && curr.isRed == true) ||
                        (edge.isRed == true && curr.isRed == false)) {
                        if(edge.isRed && !redVisited[edge.dest])
                            queue.add(new Edge(edge.isRed, edge.dest, curr.distance + 1));
                        if(!edge.isRed && !blueVisited[edge.dest])
                            queue.add(new Edge(edge.isRed, edge.dest, curr.distance + 1));
                    }
                }
            }

        }
        return distance;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] red_edges = {{0,1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] blue_edges = {{1,2},{2,3},{3,1}};

        System.out.println(new AlternatingColor().shortestAlternatingPaths(n, red_edges, blue_edges));
    }
}
