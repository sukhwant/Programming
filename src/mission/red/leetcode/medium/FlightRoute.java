package mission.red.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FlightRoute {

    public class Pair{
        public int src;
        public int dest;
        public int cost;

        public Pair(final int src, final int dest, final int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    public class Route{

        public final int node;
        public final int k;
        public int cost;

        public Route(final int node, final int k, final int cost) {
            this.node = node;
            this.k = k;
            this.cost = cost;
        }
    }

    public int bfs(
        final Map<Integer, List<Pair>> graph, final int src, final int dst, final int k){

        Queue<Route> queue = new LinkedList<>();
        queue.add(new Route(src, 0, 0));
        Map<Integer, Boolean> visited = new HashMap<>();
        int currK = 0;
        visited.put(src, Boolean.TRUE);

        int minCost = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Route curr = queue.remove();
            System.out.println("curr is: " + curr.node + " " + curr.k + " " + curr.cost);

            if(curr.k > k + 1){
                break;
            }
            if(curr.node == dst){
                minCost = Math.min(minCost, curr.cost);
            }

            if(graph.containsKey(curr.node)) {
                for (Pair neighbours : graph.get(curr.node)) {
                    queue.add(new Route(neighbours.dest, curr.k + 1, curr.cost + neighbours.cost));
                }
            }
        }

        if(minCost == Integer.MAX_VALUE)
            return -1;
        return minCost;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < flights.length; i++) {
            graph.putIfAbsent(flights[i][0], new LinkedList<>());
            graph.get(flights[i][0]).add(new Pair(flights[i][0], flights[i][1], flights[i][2]));
        }
        return bfs(graph, src, dst, K);
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0, dst = 2, k = 1;

        System.out.println(new FlightRoute().findCheapestPrice(n, edges, src, dst, k));
    }
}
