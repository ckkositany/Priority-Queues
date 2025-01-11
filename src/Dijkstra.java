import java.util.*;

public class Dijkstra {
    private final Map<String, List<Edge>> adjacencyList;

    public Dijkstra() {
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
     */
    public void addEdge(String from, String to, double weight) {
        adjacencyList.get(from).add(new Edge(to, weight));
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
     * Retrieves all nodes in the graph.
     * 
     * @return Set of node names.
     */
    public Set<String> getNodes() {
        return adjacencyList.keySet();
    }

    public static class Edge {
        public final String destination;
        public final double weight;

        public Edge(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static List<String> findShortestPath(Graph graph, String start, String destination) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findShortestPath'");
    }
}
