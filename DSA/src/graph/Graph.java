package graph;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<Vertex, List<Vertex>> adjacentVertices = new HashMap<>();


    public void addVertex(@NotNull String label){
        adjacentVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(@NotNull String label){
        Vertex v= new Vertex(label);
        adjacentVertices.values().forEach(e -> e.remove(v));
        adjacentVertices.remove(new Vertex(label));
    }

    void addEdge(@NotNull String label1, @NotNull String label2){
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjacentVertices.get(v2).add(v1);
        adjacentVertices.get(v1).add(v2);
    }

    void removeEdge(@NotNull String label1, @NotNull String label2){
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List<Vertex> ev1 = adjacentVertices.get(v1);
        List<Vertex> ev2 = adjacentVertices.get(v2);

        if (ev1 != null)
            removeVertex(label1);
        if (ev2 != null)
            removeVertex(label2);
    }

    /**
     * Instantiates a basic graph, with two nodes (Vertex1 and Vertex2) and
     * an edge connecting them.
     * Subsequently, further nodes can be added.
     * NB: method made `static` to allow main method to call it at execution time
     * @return the newly created graph
     */
    public static Graph createGraph(){
        Graph graph = new Graph();
        graph.addVertex("Vertex1");
        graph.addVertex("Vertex2");
        graph.addVertex("Vertex3");
        graph.addVertex("Vertex4");
        graph.addVertex("Vertex5");
        graph.addEdge("Vertex1", "Vertex2");
        graph.addEdge("Vertex1", "Vertex4");
        graph.addEdge("Vertex2", "Vertex3");
        graph.addEdge("Vertex2", "Vertex5");
        graph.addEdge("Vertex4", "Vertex5");
//        graph.removeVertex(null);
//        graph.removeEdge(null, null);
        return graph;
    }

    List<Vertex> getAdjacentVertices(@NotNull String label){
        //noinspection SuspiciousMethodCalls
        return adjacentVertices.get(label);
    }
}
