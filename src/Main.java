/**
 * Author: kositany ck
 * Purpose: Orchestrates the application by combining all components.
 * Description: This class manages user interaction and integrates all
 *              other classes for the routing application.
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = InputOutput.createGraph();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter start location: ");
        String start = scanner.nextLine();

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        List<String> path = Dijkstra.findShortestPath(graph, start, destination);
        InputOutput.displayPath(path);
    }
}
