package Assignment4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Search<Vertex> {
    protected Set<Vertex> visited;
    protected Map<Vertex, Vertex> edgeTo;
    protected final Vertex source;

    public Search(Vertex source) {
        this.source = source;
        visited = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex v) {
        return visited.contains(v);
    }

    public Iterable<Vertex> pathTo(Vertex v) {
        if (!hasPathTo(v)) return null;

        LinkedList<Vertex> ls = new LinkedList<>();
        for (Vertex i = v; i != this.source; edgeTo.get(i)) {
            ls.push(i);
        }

        ls.push(source);

        return ls;
    } 
}
