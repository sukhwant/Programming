package javatutorial.algorithms.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javatutorial.algorithms.graph.model.GraphEdge;
import javatutorial.algorithms.graph.model.GraphNode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Graph {

    private Map<GraphNode, List<GraphEdge>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public void addEdge(GraphEdge edge) {
        if (!edge.isDirected()) {
            add(edge);
            add(new GraphEdge(edge.getDestination(), edge.getSource(), edge.getWeight()));
        } else {
            add(edge);
        }
    }

    private void add(GraphEdge edge) {
        if (!graph.containsKey(edge.getSource())) {
            List<GraphEdge> edgeList = new LinkedList<>();
            edgeList.add(edge);
            graph.put(edge.getSource(), edgeList);
        } else {
            graph.get(edge.getSource()).add(edge);
        }
    }

    public Set<GraphNode> getNodes() {
        return graph.keySet();
    }

    public List<GraphEdge> getEdge(GraphNode node) {
        if (!graph.containsKey(node)) {
            System.out.println("Node not found...");
        }
        return graph.get(node);
    }
}
