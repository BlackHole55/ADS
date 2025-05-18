package Assignment4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private final Set<Vertex> unsettledNodes;
    private final Map<Vertex, Double> distance;
    private final MyGraph<Vertex> graph;

    public DijkstraSearch(MyGraph<Vertex> graph, Vertex source) {
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
            Vertex currentNode = getVertexWithMinimumWeight(unsettledNodes);

            visited.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Vertex neighbor : graph.adjacentVectorsList(currentNode)) {
                Double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                if (getShortestDistance(neighbor) > newDistance) {
                    distance.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private Double getDistance(Vertex source, Vertex destination) {
        for (Edge<Vertex> edge : graph.getEdges(source)) {
            if (edge.getDestination().equals(destination)) {
                return edge.getWeight();
            }
        }

        return Double.MAX_VALUE;
    }

    private Vertex getVertexWithMinimumWeight(Set<Vertex> vertices) {
        Vertex minimum = null;
        for (Vertex vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }

        return minimum;
    }

    private Double getShortestDistance(Vertex destination) {
        Double d = distance.get(destination);

        return (d == null ? Double.MAX_VALUE : d);
    }
}
