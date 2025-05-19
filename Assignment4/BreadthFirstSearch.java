package Assignment4;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(MyGraph<T> graph, T source) {
        super(source);

        Vertex<T> sourceVertex = new Vertex<>(source);
        bfs(graph, sourceVertex);
    }

    private void bfs(MyGraph<T> graph, Vertex<T> current) {
        visited.add(current);

        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex<T> v = queue.remove();

            for (Vertex<T> vertex : graph.adjacentVectorsList(v)) {
                if (!visited.contains(vertex)) {
                    visited.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}