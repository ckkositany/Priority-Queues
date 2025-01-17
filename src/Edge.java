public class Edge {
    private final String startNode;
    private final String endNode;
    private final int weight;

    // Constructor
    public Edge(String startNode, String endNode, int weight) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
    }

    // Getters
    public String getStartNode() {
        return startNode;
    }

    public String getEndNode() {
        return endNode;
    }

    public int getWeight() {
        return weight;
    }
}
