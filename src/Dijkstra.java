import java.util.*;

public class Dijkstra {
    public static Map<String, Integer> calculateShortestPath(Graph graph, String startNode) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        Set<String> visited = new HashSet<>();

        // Initialize distances
        for (String node : graph.getAdjacencyList().keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(startNode, 0);
        priorityQueue.add(startNode, 0);

        // Process the priority queue
        while (!priorityQueue.isEmpty()) {
            String currentNode = priorityQueue.remove();

            if (visited.contains(currentNode)) {
                continue;
            }
            visited.add(currentNode);

            for (Edge edge : graph.getAdjacencyList().get(currentNode)) {
                String neighbor = edge.getEndNode();
                int newDistance = distances.get(currentNode) + edge.getWeight();

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    priorityQueue.add(neighbor, newDistance);
                }
            }
        }
        return distances;
    }
}
