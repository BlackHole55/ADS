package Assignment4;

import java.util.Objects;

public class Edge<Vertex> {
    private Vertex source;
    private Vertex destination;
    private double weight;

    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
    }

    public Edge(Vertex source, Vertex destination, double weight) {
        this(source, destination);
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }
    
    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        // references
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Edge<?> otherEdge = (Edge<?>) o;

        return Objects.equals(this.source, otherEdge.source) && Objects.equals(this.destination, otherEdge.destination);
    }
}
