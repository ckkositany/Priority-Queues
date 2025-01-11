
/**
 * Purpose: Orchestrates the application by combining all components.
 * Description: This class manages user interaction and integrates all
 *              other classes for the routing application.
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a graph using the InputOutput helper class
        Graph graph = InputOutput.createGraph();
        Scanner scanner = new Scanner(System.in);

        // Get user input for start and destination
        System.out.print("Enter start location: ");
        String start = scanner.nextLine();

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        // Find the shortest path using Dijkstra's algorithm
        List<String> path = Dijkstra.findShortestPath(graph, start, destination);

        // Display the result path
        InputOutput.displayPath(path);
    }
}
