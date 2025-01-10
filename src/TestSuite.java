/**

 * Author: Damiano

 * Purpose: Provides test cases to validate the application.

 * Description: This class ensures that the graph, priority queue, and

 *              Dijkstra algorithm work as expected.

 */

public class TestSuite {

    public static void test() {

        Graph graph = new Graph();

        graph.addNode("A");

        graph.addNode("B");

        graph.addNode("C");

        graph.addEdge("A", "B", 1);

        graph.addEdge("B", "C", 2);

        graph.addEdge("A", "C", 4);



        List<String> path = Dijkstra.findShortestPath(graph, "A", "C");

        assert path.equals(List.of("A", "B", "C")) : "Test failed!";

        System.out.println("Test passed!");

    }

}