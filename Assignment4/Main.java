package Assignment4;

public class Main {
    public static void main(String[] args) {
        MyGraph<String> weightedGraph = new MyGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<String>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");

        System.out.println("--------------------------------");

        MyGraph<String> graph = new MyGraph<>(true);
        fillWithWeights(graph);

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<String>(graph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    public static void fillWithWeights(MyGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    public static void outputPath(Search<String> search, String key) {
        for (Vertex<String> v : search.pathTo(key)) {
            String strV = v.toString(); 
            if (strV.equals(key)) {
                System.out.print(v);
                break;
            }

            System.out.print(v + " -> ");
        }

        System.out.println();
    }
}