package Assignment4;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MyGraph<Vertex> {
    private Map<Vertex, List<Edge<Vertex>>> graph = new HashMap<>();
    private boolean undirected;

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public MyGraph() {
        this(true);
    }

    public boolean hasVertex(Vertex v) {
        return graph.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex destination) {
        if (!hasVertex(source)) {
            return false;
        }

        return graph.get(source).contains(new Edge<>(source, destination));
    }

    public void addVertex(Vertex v) {
        if (hasVertex(v)) {
            return;
        }

        graph.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex destination, Double weight) {
        if (!hasVertex(source)) {
            addVertex(source);
        }

        if (!hasVertex(destination)) {
            addVertex(destination);
        }

        if (hasEdge(source, destination) || source.equals(destination)) {
            return;
        }
        
        graph.get(source).add(new Edge<>(source, destination, weight));

        if (undirected) {
            graph.get(destination).add(new Edge<>(destination, source, weight));
        }
    }

    public int getVerticesCount() {
        return graph.size();
    }

    public int getEdgesCount() {
        int count = 0;

        for (Vertex v : graph.keySet()) {
            count += graph.get(v).size();
        }

        if (undirected) {
            count /= 2;
        }

        return count;
    }

    public List<Vertex> adjacentVectorsList(Vertex v) {
        if (!hasVertex(v)) {
            return null;
        }

        List<Vertex> vertices = new LinkedList<>();
        for (Edge<Vertex> e : graph.get(v)) {
            vertices.add(e.getDestination());
        }

        return vertices;
    }

    public List<Edge<Vertex>> getEdges(Vertex v) {
        if (!hasVertex(v)) {
            return null;
        }

        return graph.get(v);
    }
}
