package Assignment4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraSearch<T> extends Search<T> {
    private final Set<Vertex<T>> unsettledNodes;
    private final Map<Vertex<T>, Double> distance;
    private final MyGraph<T> graph;

    public DijkstraSearch(MyGraph<T> graph, T source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distance = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    public void dijkstra() {
        distance.put(source, 0.0);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex<T> currentNode = getVertexWithMinimumWeight(unsettledNodes);

            visited.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Vertex<T> neighbor : graph.adjacentVectorsList(currentNode)) {
                Double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                if (getShortestDistance(neighbor) > newDistance) {
                    distance.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private Double getDistance(Vertex<T> source, Vertex<T> destination) {
        // System.out.println(graph.getEdges(source));
        for (Map.Entry<Vertex<T>, Double> edge : graph.getEdges(source).entrySet()) {
            if (edge.getKey().equals(destination)) {
                return edge.getValue();
            }
        }

        return Double.MAX_VALUE;
    }

    private Vertex<T> getVertexWithMinimumWeight(Set<Vertex<T>> vertices) {
        Vertex<T> minimum = null;
        for (Vertex<T> vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }

        return minimum;
    }

    private Double getShortestDistance(Vertex<T> destination) {
        Double d = distance.get(destination);

        return (d == null ? Double.MAX_VALUE : d);
    }
}
