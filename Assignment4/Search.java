package Assignment4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Search<T> {
    protected Set<Vertex<T>> visited;
    protected Map<Vertex<T>, Vertex<T>> edgeTo;
    protected final Vertex<T> source;

    public Search(T source) {
        Vertex<T> sourceVertex = new Vertex<>(source);
        this.source = sourceVertex;
        visited = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<T> v) {
        return visited.contains(v);
    }

    public Iterable<Vertex<T>> pathTo(T v) {
        Vertex<T> vertex = new Vertex<>(v);
        if (!hasPathTo(vertex)) {
            return null;
        }

        LinkedList<Vertex<T>> ls = new LinkedList<>();
        for (Vertex<T> i = vertex; !i.equals(this.source); i = edgeTo.get(i)) {
            ls.push(i);
        }

        ls.push(source);

        return ls;
    } 
}
