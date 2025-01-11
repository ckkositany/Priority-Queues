import java.util.*;

/**
 * A class representing a directed weighted graph using an adjacency list.
 * The graph stores vertices (nodes) and the edges (with weights) that connect them.
 */
public class Graph {
    private final Map<String, List<Edge>> adjacencyList;

    /**
     * Constructor for creating a new empty graph.
     * Initializes the adjacency list to store nodes and their connected edges.
     */
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Adds a vertex (node) to the graph. If the node already exists, it does nothing.
     *
     * @param node The name of the node to add to the graph.
     * @throws NullPointerException If the node is null.
     */
    public void addVertex(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Adds a directed edge from one node to another with a specified weight.
     * If either node does not exist, it will be added to the graph first.
     *
     * @param from The source node where the edge originates.
     * @param to The destination node where the edge points.
     * @param weight The weight (distance) of the edge.
     *
     * @throws NullPointerException If any of the parameters are null.
     * @throws IllegalArgumentException If weight is negative.
     */
    public void addEdge(String from, String to, double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Edge weight cannot be negative.");
        }
        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.putIfAbsent(to, new ArrayList<>());
        adjacencyList.get(from).add(new Edge(to, weight));
    }

    /**
     * Retrieves the list of edges connected to a node.
     * If the node does not exist, an empty list is returned.
     *
     * @param node The node whose neighbors' edges are to be retrieved.
     * @return A list of edges connected to the node, or an empty list if no neighbors exist.
     */
    public List<Edge> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    /**
     * Retrieves all the vertices (nodes) in the graph.
     *
     * @return A set of all node names (vertices) in the graph.
     */
    public Set<String> getVertices() {
        return adjacencyList.keySet();
    }

    /**
     * Adds a node to the graph, but this method is currently unused and does nothing.
     *
     * @param nairobi The name of the node to add (unused in the current implementation).
     * @throws UnsupportedOperationException This method does not do anything.
     */
    public void addNode(String nairobi) {
        // This method is currently not needed and doesn't perform any action.
    }

    /**
     * Inner class representing an edge in the graph.
     * An edge has a destination node and a weight (distance).
     */
    public static class Edge {
        public final String destination; // The destination node of the edge
        public final double weight; // The weight of the edge

        /**
         * Constructor to create an edge with a destination and weight.
         *
         * @param destination The destination node of the edge.
         * @param weight The weight (distance) of the edge.
         *
         * @throws NullPointerException If destination is null.
         * @throws IllegalArgumentException If weight is negative.
         */
        public Edge(String destination, double weight) {
            if (destination == null) {
                throw new NullPointerException("Destination node cannot be null.");
            }
            if (weight < 0) {
                throw new IllegalArgumentException("Edge weight cannot be negative.");
            }
            this.destination = destination;
            this.weight = weight;
        }
    }
}
