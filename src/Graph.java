import java.util.*;

public class Graph {
    private final Map<String, List<Edge>> adjacencyList;

    // Constructor
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // Method to add an edge
    public void addEdge(String startNode, String endNode, int weight) {
        // Initialize the adjacency list for the start and end nodes if not already
        // present
        adjacencyList.putIfAbsent(startNode, new ArrayList<>());
        adjacencyList.putIfAbsent(endNode, new ArrayList<>());

        // Add the edge
        adjacencyList.get(startNode).add(new Edge(startNode, endNode, weight));
    }

    // Get adjacency list
    public Map<String, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }
}
