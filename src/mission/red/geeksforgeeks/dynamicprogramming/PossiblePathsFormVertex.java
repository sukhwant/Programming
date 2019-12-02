package mission.red.geeksforgeeks.dynamicprogramming;

/**
 * https://www.geeksforgeeks.org/count-possible-paths-source-destination-exactly-k-edges/
 * 
 * @author sukhwanp
 *
 */
public class PossiblePathsFormVertex {

    public static int countwalks(int[][] graph, int source, int destination, int numberOfNodes) {

        int result[] = new int[graph.length];
        int visited[] = new int[graph.length];

        int currNode = source;
        return 0;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 } };
        int u = 0, v = 3, k = 2;
        System.out.println(countwalks(graph, u, v, k));
    }

}
