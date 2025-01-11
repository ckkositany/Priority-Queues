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
       
        // Purpose: Represents the graph structure with nodes and weighted edges.
        // Description: This class provides methods to add nodes and edges to the graphs//              and retrieve adjacency list data.
       import java.util.*;
       
       public class Graph {
           private final Map<String, List<Edge>> adjacencyList;
       
           public Graph() {
               adjacencyList = new HashMap<>();
           }
       
           /**
            * Adds a node to the graph.
            * @param node The name of the node to add.
            */
           public void addNode(String node) {
               adjacencyList.putIfAbsent(node, new ArrayList<>());
           }
       
           /**
            * Adds a directed edge to the graph with a weight.
            * @param from Source node.
            * @param to Destination node.
            * @param weight Weight of the edge.
            */
           public void addEdge(String from, String to, double weight) {
               adjacencyList.get(from).add(new Edge(to, weight));
           }
       
           /**
            * Retrieves the edges connected to a node.
            * @param node The node to query.
            * @return List of edges.
            */
           public List<Edge> getEdges(String node) {
               return adjacencyList.getOrDefault(node, Collections.emptyList());
           }
       
           /**
            * Retrieves all nodes in the graph.
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
       }

    }
}
