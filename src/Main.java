import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example graph initialization
        Graph graph = new Graph();
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 10);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 1);

        System.out.println("Enter start location: ");
        String startLocation = scanner.nextLine();

        // Calculate shortest paths
        Map<String, Integer> shortestPaths = Dijkstra.calculateShortestPath(graph, startLocation);

        // Display the results
        System.out.println("Shortest paths from " + startLocation + ":");
        for (Map.Entry<String, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("To " + entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}
