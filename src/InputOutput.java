import java.util.*;

/**
 * A utility class for handling input and output operations related to graphs.
 * This class provides methods for creating a graph based on user input and
 * displaying the shortest path between nodes.
 */
public class InputOutput {

    /**
     * Creates a graph based on user-provided input.
     * The user is prompted to enter the number of locations (nodes) and the number
     * of roads (edges). Each location is identified by a unique name, and each
     * road is defined by its starting location, ending location, and weight.
     *
     * @return A {@code Graph} object constructed with the specified nodes and edges.
     */
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

    /**
     * Displays the shortest path between nodes.
     * If a path exists, it is displayed as a sequence of nodes connected by "->".
     * If no path exists, a message indicating that is displayed.
     *
     * @param path A {@code List<String>} containing the nodes in the shortest path.
     *             The list should represent the order of nodes from source to
     *             destination.
     */
    public static void displayPath(List<String> path) {
        if (path.isEmpty()) {
            System.out.println("No path found!");
        } else {
            System.out.println("Shortest Path: " + String.join(" -> ", path));
        }
    }
}
