package javatutorial.algorithms.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javatutorial.datastructure.PriorityQueue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Dijkstra {

    @AllArgsConstructor
    @Getter
    @Setter
    private static class DijkstraResult implements Comparable<DijkstraResult> {
        GraphNode node;
        GraphNode source;
        int distance;

        @Override
        public int compareTo(DijkstraResult o) {
            return this.distance - o.distance;
        }
    }

    private static Map<GraphNode, DijkstraResult> dijkstra(Graph graph, GraphNode source) {

        PriorityQueue<DijkstraResult> queue = new PriorityQueue<>();
        Map<GraphNode, DijkstraResult> resultMap = initializeResult(graph, source);

        // add nodes to priority queue.
        for (Map.Entry<GraphNode, DijkstraResult> entry : resultMap.entrySet()) {
            queue.enqueue(entry.getValue());
        }

        while (!queue.isEmpty()) {
            GraphNode sourceNode = queue.dequeue().getNode();
            DijkstraResult sourceResult = resultMap.get(sourceNode);
            List<GraphEdge> neighbours = graph.getEdge(sourceNode);

            for (GraphEdge edge : neighbours) {
                DijkstraResult currentResult = resultMap.get(edge.getDestination());
                if (currentResult.getDistance() > sourceResult.getDistance() + edge.getWeight()) {
                    DijkstraResult oldResult = currentResult;
                    currentResult.setDistance(sourceResult.getDistance() + edge.getWeight());
                    currentResult.setSource(sourceNode);
                    queue.decreaseValue(oldResult, currentResult);
                }
            }
        }
        return resultMap;
    }

    private static Map<GraphNode, DijkstraResult> initializeResult(Graph graph, GraphNode source) {
        Map<GraphNode, DijkstraResult> result = new HashMap<>();
        Set<GraphNode> nodes = graph.getNodes();
        for (GraphNode node : nodes) {
            if (node == source) {
                result.put(node, new DijkstraResult(node, null, 0));
            } else {
                result.put(node, new DijkstraResult(node, null, Integer.MAX_VALUE));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Graph graph = new Graph();

        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        GraphNode nodeD = new GraphNode("D");
        GraphNode nodeE = new GraphNode("E");
        GraphNode nodeF = new GraphNode("G");

        graph.addEdge(new GraphEdge(nodeA, nodeB, 2, false));
        graph.addEdge(new GraphEdge(nodeA, nodeD, 1, false));
        graph.addEdge(new GraphEdge(nodeA, nodeF, 4, false));
        graph.addEdge(new GraphEdge(nodeB, nodeC, 5, false));
        graph.addEdge(new GraphEdge(nodeB, nodeE, 2, false));
        graph.addEdge(new GraphEdge(nodeC, nodeD, 3, false));
        graph.addEdge(new GraphEdge(nodeC, nodeF, 3, false));
        graph.addEdge(new GraphEdge(nodeD, nodeE, 2, false));
        graph.addEdge(new GraphEdge(nodeE, nodeF, 1, false));

        Map<GraphNode, DijkstraResult> result = dijkstra(graph, nodeA);

        System.out.println("Done...");
    }
}
