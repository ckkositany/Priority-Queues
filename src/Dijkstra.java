import java.util.*;

/**
 * A class implementing Dijkstra's algorithm to find the shortest path between two nodes in a graph.
 */
public class Dijkstra {

    /**
     * Finds the shortest path from the start node to the destination node in the given graph using Dijkstra's algorithm.
     *
     * @param graph The graph in which to find the shortest path. It must implement methods to retrieve vertices and neighbors.
     * @param start The name of the starting node in the graph. It must be a valid node within the graph.
     * @param destination The name of the destination node in the graph. It must be a valid node within the graph.
     *
     * @return A string representation of the shortest path from the start node to the destination node, along with the total distance (weight).
     *         The format is: "Shortest path from {start} to {destination}: {path} with total distance: {totalDistance} km".
     *
     * @throws IllegalArgumentException If either the start or destination node does not exist in the graph.
     * @throws RuntimeException If no path is found from start to destination.
     */
    public static String findShortestPath(Graph graph, String start, String destination) {
        // Check if the start and destination nodes exist in the graph
        if (!graph.getVertices().contains(start) || !graph.getVertices().contains(destination)) {
            throw new IllegalArgumentException("Start or destination node does not exist in the graph.");
        }

        // Maps to track distances and the previous node in the shortest path
        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();

        // Priority queue to process nodes by their distance (used in Dijkstra's algorithm)
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(n -> n.distance));
        Set<String> visited = new HashSet<>();

        // Initialize distances for all nodes
        for (Object vertex : graph.getVertices()) {
            distances.put((String) vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);
        pq.add(new Node(start, 0.0));

        // Dijkstra's algorithm loop
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (!visited.add(current.name)) continue;

            // If we have reached the destination node, break the loop
            if (current.name.equals(destination)) break;

            // Update distances for neighbors of the current node
            for (Graph.Edge edge : graph.getNeighbors(current.name)) {
                if (visited.contains(edge.destination)) continue;

                double newDistance = distances.get(current.name) + edge.weight;
                if (newDistance < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDistance);
                    previous.put(edge.destination, current.name);
                    pq.add(new Node(edge.destination, newDistance));
                }
            }
        }

        // Reconstruct the path from start to destination
        List<String> path = new LinkedList<>();
        for (String at = destination; at != null; at = previous.get(at)) {
            path.add(0, at);
        }

        // If the destination node is not reachable, throw an exception
        if (path.size() == 1 && !path.get(0).equals(start)) {
            throw new RuntimeException("No path found from " + start + " to " + destination);
        }

        // Calculate the total distance of the path
        double totalDistance = distances.get(destination);

        // Return the path along with the total distance
        return "Shortest path from " + start + " to " + destination + ": " + path + " with total distance: " + totalDistance + " km";
    }

    /**
     * A helper class to represent a node in the priority queue for Dijkstra's algorithm.
     * Each node stores the name of the vertex and its current distance from the source node.
     */
    private static class Node {
        String name; // The name of the node
        double distance; // The distance from the start node

        // Constructor for creating a Node instance
        Node(String name, double distance) {
            this.name = name;
            this.distance = distance;
        }
    }
}
