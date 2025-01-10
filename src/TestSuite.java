/**
 * Author: Damiano
 * Purpose:
 * This class provides a basic test case to validate the functionality
 * of a graph data structure, priority queue, and Dijkstra's shortest path algorithm.
 * Description:
 * The `TestSuite` class ensures that:
 * - Nodes and edges can be added to a graph.
 * - Dijkstra's algorithm can compute the shortest path between two nodes.
 * - The implementation produces the expected results for a specific test case.
 */

public class TestSuite {

    /**
     * The main test method that performs the following:
     * 1. Initializes a graph with three nodes and three edges.
     * 2. Computes the shortest path between two nodes using Dijkstra's algorithm.
     * 3. Validates the result against the expected shortest path.
     * 4. Outputs success or failure based on the test outcome.
     */
    public static void test() {

        // Step 1: Create a new graph instance
        Graph graph = new Graph();

        // Step 2: Add nodes to the graph
        // Nodes represent entities in the graph
        graph.addNode("A"); // Add node "A"
        graph.addNode("B"); // Add node "B"
        graph.addNode("C"); // Add node "C"

        // Step 3: Add edges with weights to the graph
        // Edges represent connections between nodes with specific weights (costs)
        graph.addEdge("A", "B", 1); // Edge from "A" to "B" with weight 1
        graph.addEdge("B", "C", 2); // Edge from "B" to "C" with weight 2
        graph.addEdge("A", "C", 4); // Edge from "A" to "C" with weight 4

        // Step 4: Use Dijkstra's algorithm to compute the shortest path
        // Find the shortest path from node "A" to node "C"
        List<String> path = Dijkstra.findShortestPath(graph, "A", "C");

        // Step 5: Validate the result
        // Expected shortest path: ["A", "B", "C"], total cost = 1 + 2 = 3
        assert path.equals(List.of("A", "B", "C")) : "Test failed!";

        // Step 6: Output the test result
        // If the assertion passes, print "Test passed!"
        System.out.println("Test passed!");
    }
}
