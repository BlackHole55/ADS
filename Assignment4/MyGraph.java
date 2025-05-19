package Assignment4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyGraph<T> {
    private List<Vertex<T>> graph = new ArrayList<>();
    private boolean undirected;

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public MyGraph() {
        this(true);
    }

    public boolean hasVertex(Vertex<T> v) {
        return graph.contains(v);
    }

    public boolean hasEdge(Vertex<T> source, Vertex<T> destination) {
        if (!hasVertex(source)) {
            return false;
        }
        int index = graph.indexOf(source);
        Vertex<T> actualSource = graph.get(index);

        return actualSource.getAdjacentVertices().containsKey(destination);
    }

    public void addVertex(T v) {
        Vertex<T> newVertex = new Vertex<T>(v);

        if (hasVertex(newVertex)) {
            return;
        }

        graph.add(newVertex);
    }

    public void addEdge(T source, T destination, Double weight) {
        Vertex<T> sourceVertex = new Vertex<>(source);

        Vertex<T> destVertex = new Vertex<>(destination);

        if (!hasVertex(sourceVertex)) {
            addVertex(source);
        }

        if (!hasVertex(destVertex)) {
            addVertex(destination);
        }

        int indexOfSource = graph.indexOf(sourceVertex);
        sourceVertex = graph.get(indexOfSource);

        int indexOfDest = graph.indexOf(destVertex);
        destVertex = graph.get(indexOfDest);

        if (hasEdge(sourceVertex, destVertex) || sourceVertex.equals(destVertex)) {
            return;
        }

        sourceVertex.addAdjacentVertex(destVertex, weight);

        if (undirected) {
            destVertex.addAdjacentVertex(sourceVertex, weight);
        }
    }

    public int getVerticesCount() {
        return graph.size();
    }

    public int getEdgesCount() {
        int count = 0;

        for (int i = 0; i < graph.size(); i++) {
            count += graph.get(i).getAdjacentVertices().size();
        }

        if (undirected) {
            count /= 2;
        }

        return count;
    }

    public List<Vertex<T>> adjacentVectorsList(Vertex<T> v) {
        if (!hasVertex(v)) {
            return null;
        }
        
        int index = graph.indexOf(v);
        Vertex<T> actualVertex = graph.get(index);

        List<Vertex<T>> vertices = new LinkedList<>();
        vertices.addAll(actualVertex.getAdjacentVertices().keySet());

        return vertices;
    }

    public Map<Vertex<T>, Double> getEdges(Vertex<T> v) {
        if (!hasVertex(v)) {
            return null;
        }

        int index = graph.indexOf(v);
        Vertex<T> actualVertex = graph.get(index);

        return actualVertex.getAdjacentVertices();
    }
}
