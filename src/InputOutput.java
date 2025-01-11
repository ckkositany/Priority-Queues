import java.util.*;

public class InputOutput {
    public static Graph createGraph() {
        Graph graph = new Graph();

        // Add major cities as nodes
        graph.addNode("Nairobi");
        graph.addNode("Mombasa");
        graph.addNode("Kisumu");
        graph.addNode("Eldoret");
        graph.addNode("Nakuru");
        graph.addNode("Malindi");
        graph.addNode("Garissa");

        // Add edges with distances as weights (in kilometers)
        graph.addEdge("Nairobi", "Mombasa", 484);
        graph.addEdge("Nairobi", "Kisumu", 350);
        graph.addEdge("Nairobi", "Eldoret", 310);
        graph.addEdge("Nairobi", "Nakuru", 160);
        graph.addEdge("Mombasa", "Malindi", 120);
        graph.addEdge("Nakuru", "Kisumu", 180);
        graph.addEdge("Eldoret", "Garissa", 460);

        // Add reverse edges if the graph is undirected
        graph.addEdge("Mombasa", "Nairobi", 484);
        graph.addEdge("Kisumu", "Nairobi", 350);
        graph.addEdge("Eldoret", "Nairobi", 310);
        graph.addEdge("Nakuru", "Nairobi", 160);
        graph.addEdge("Malindi", "Mombasa", 120);
        graph.addEdge("Kisumu", "Nakuru", 180);
        graph.addEdge("Garissa", "Eldoret", 460);

        return graph;
    }

    public static void displayPath(List<String> path) {
        if (path == null || path.isEmpty()) {
            System.out.println("No path found between the specified locations.");
            return;
        }
        System.out.println("Shortest path:");
        for (String node : path) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
