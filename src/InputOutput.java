import java.util.*;

public class InputOutput {
    /**
     * Creates a sample graph with nodes and edges.
     * 
     * @return A Graph object.
     */
    public static Graph createGraph() {
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 1.0);
        graph.addEdge("B", "C", 2.0);
        graph.addEdge("A", "C", 2.5);
        return graph;
    }

    /**
     * Displays the path from source to destination.
     * 
     * @param path The list of nodes representing the path.
     */
    public static void displayPath(List<String> path) {
        if (path.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println("Shortest path: " + String.join(" -> ", path));
        }
    }
}
