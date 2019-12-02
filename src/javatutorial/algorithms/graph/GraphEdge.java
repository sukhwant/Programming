package javatutorial.algorithms.graph;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GraphEdge {

    private GraphNode source;
    private GraphNode destination;
    private int weight;

    private boolean isDirected;

    public GraphEdge(GraphNode source, GraphNode destination, int weight, boolean isDirected) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.isDirected = isDirected;
    }

    public GraphEdge(GraphNode source, GraphNode destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

}
