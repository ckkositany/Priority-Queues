/**
 * Author: Andrian
 * Purpose: Manages user input and output for the application.
 * Description: This class provides methods for creating a graph from user input
 *              and displaying the calculated shortest path.
 */
import java.util.*;

public class InputOutput {
    public static Graph createGraph() {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        System.out.print("Enter number of locations: ");
        int nodes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < nodes; i++) {
            System.out.print("Enter location name: ");
            graph.addNode(scanner.nextLine());
        }

        System.out.print("Enter number of roads: ");
        int edges = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < edges; i++) {
            System.out.print("Enter road (from to weight): ");
            String from = scanner.next();
            String to = scanner.next();
            double weight = scanner.nextDouble();
            graph.addEdge(from, to, weight);
        }

        return graph;
    }

    public static void displayPath(List<String> path) {
        if (path.isEmpty()) {
            System.out.println("No path found!");
        } else {
            System.out.println("Shortest Path: " + String.join(" -> ", path));
        }
    }
}