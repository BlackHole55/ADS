package Assignment4;

import java.util.HashMap;
import java.util.Map;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices = new HashMap<>();

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void addAdjacentVertex(Vertex<T> destination, Double weight) {
        adjacentVertices.put(destination, weight);
    }

    @Override
    public boolean equals(Object o) {
        // reference
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vertex<?> otherVertex = (Vertex<?>) o;

        return data != null ? data.equals(otherVertex.data) : otherVertex.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
