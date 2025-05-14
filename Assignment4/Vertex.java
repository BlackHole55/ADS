package Assignment4;

import java.util.Map;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void addAdjacentVertex(Vertex<T> destination, Double weight) {
        adjacentVertices.put(destination, weight);
    }

    @Override
    public boolean equals(Object o) {
        // reference
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vertex<?> otherVertex = (Vertex<?>) o;

        if (this.data.equals(otherVertex.data)) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Vertex{" + "data=" + data + "}";
    }
}
