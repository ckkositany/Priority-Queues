import java.util.*;

public class Graph {
    private final Map<String, List<Edge>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Adds a node to the graph.
     * 
     * @param node The name of the node to add.
     */
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Adds a directed edge to the graph with a weight.
     * 
     * @param from   Source node.
     * @param to     Destination node.
     * @param weight Weight of the edge.
     * @throws IllegalArgumentException if either node does not exist.
     */
    public void addEdge(String from, String to, double weight) {
        validateNode(from);
        validateNode(to);
        adjacencyList.get(from).add(new Edge(to, weight));
    }

    /**
     * Adds a bidirectional edge (undirected) between two nodes with a weight.
     * 
     * @param node1  First node.
     * @param node2  Second node.
     * @param weight Weight of the edge.
     * @throws IllegalArgumentException if either node does not exist.
     */
    public void addBidirectionalEdge(String node1, String node2, double weight) {
        addEdge(node1, node2, weight);
        addEdge(node2, node1, weight);
    }

    /**
     * Retrieves the edges connected to a node.
     * 
     * @param node The node to query.
     * @return List of edges.
     */
    public List<Edge> getEdges(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    /**
     * Removes a node and all its associated edges from the graph.
     * 
     * @param node The node to remove.
     */
    public void removeNode(String node) {
        adjacencyList.remove(node);
        adjacencyList.values().forEach(edges -> edges.removeIf(edge -> edge.destination.equals(node)));
    }

    /**
     * Removes a directed edge from the graph.
     * 
     * @param from Source node.
     * @param to   Destination node.
     */
    public void removeEdge(String from, String to) {
        List<Edge> edges = adjacencyList.get(from);
        if (edges != null) {
            edges.removeIf(edge -> edge.destination.equals(to));
        }
    }

    /**
     * Retrieves all nodes in the graph.
     * 
     * @return Set of node names.
     */
    public Set<String> getNodes() {
        return adjacencyList.keySet();
    }

    /**
     * Provides a string representation of the graph.
     * 
     * @return Graph as a string.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Edge>> entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey()).append(" -> ");
            for (Edge edge : entry.getValue()) {
                sb.append(edge.destination).append(" (").append(edge.weight).append("), ");
            }
            if (!entry.getValue().isEmpty()) {
                sb.setLength(sb.length() - 2); // Remove trailing comma and space
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Validates that a node exists in the graph.
     * 
     * @param node The node to validate.
     * @throws IllegalArgumentException if the node does not exist.
     */
    private void validateNode(String node) {
        if (!adjacencyList.containsKey(node)) {
            throw new IllegalArgumentException("Node does not exist: " + node);
        }
    }

    public static class Edge {
        public final String destination;
        public final double weight;

        public Edge(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
