import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add cities (nodes)
        graph.addVertex("Nairobi");
        graph.addVertex("Mombasa");
        graph.addVertex("Kisumu");
        graph.addVertex("Eldoret");

        // Add roads (edges) with weights (distances)
        graph.addEdge("Nairobi", "Mombasa", 500);
        graph.addEdge("Nairobi", "Kisumu", 300);
        graph.addEdge("Mombasa", "Eldoret", 350);
        graph.addEdge("Kisumu", "Eldoret", 200);
        graph.addEdge("Mombasa", "Kisumu", 400);

        // Find shortest path from Nairobi to Kisumu
        String path = Dijkstra.findShortestPath(graph, "Nairobi", "Kisumu");
        System.out.println("Shortest path from Nairobi to Kisumu: " + path);
    }
}
