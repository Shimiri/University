package assignment3;

import java.util.*;

public class MyDirectedGraph implements assignment3AADS.assignment3.A3Graph {
    private Map<Vertex, List<Vertex>> incomingEdges = new HashMap<>();
    private Map<Vertex, List<Vertex>> outgoingEdges = new HashMap<>();
    private List<Vertex> graph = new ArrayList<>();
    private int timeOfDisc = 0;

    @Override
    public void addVertex(int vertex) {
        incomingEdges.putIfAbsent(new Vertex(vertex), new ArrayList<>());
        outgoingEdges.putIfAbsent(new Vertex(vertex), new ArrayList<>());
        graph.add(new Vertex(vertex));
    }

    @Override
    public void addEdge(int sourceVertex, int targetVertex) {
        Vertex source = new Vertex(sourceVertex);
        Vertex target = new Vertex(targetVertex);
        outgoingEdges.get(source).add(target);
        incomingEdges.get(target).add(source);
    }

    public void removeEdge(Vertex source,
                           Vertex target,
                           Map<Vertex, List<Vertex>> outgoingEdges,
                           Map<Vertex, List<Vertex>> incomingEdges,
                           Iterator<Vertex> it) {
        it.remove();
        List<Vertex> sourceEdges = outgoingEdges.get(source);
        sourceEdges.remove(target);
        List<Vertex> targetEdges = incomingEdges.get(target);
        targetEdges.remove(source);
    }

    @Override
    public boolean isConnected() {
        SCCAlgoImpl g = new SCCAlgoImpl(graph, outgoingEdges, incomingEdges);
        List<List<Integer>> sccs = g.run();
        return sccs.size() == 1;
    }

    @Override
    public boolean isAcyclic() {
        Map<Vertex, List<Vertex>> localIncomingEdges = incomingEdges;
        Map<Vertex, List<Vertex>> localOutgoingEdges = outgoingEdges;

        List<Vertex> sorted = new ArrayList<>();
        Stack<Vertex> startVerticies = findVerticiesWithNoIncomingEdge(localIncomingEdges); // O(V)

        while (!startVerticies.isEmpty()) { // O(SV)
            Vertex v = startVerticies.pop();
            sorted.add(v);
            List<Vertex> vs = localOutgoingEdges.get(v);
            for (Iterator<Vertex> it = vs.iterator(); it.hasNext();) { // O(E)
                Vertex u = it.next();
                removeEdge(v, u, localOutgoingEdges, localIncomingEdges, it);
                if (localIncomingEdges.get(u).size() == 0)
                    startVerticies.push(u);
            }
        }
        for (List<Vertex> vs : localIncomingEdges.values()) {
            if (vs.size() != 0)
                return false;
        }
        for (List<Vertex> vs : localOutgoingEdges.values()) {
            if (vs.size() != 0)
                return false;
        }
        return true;
    }

    private Stack<Vertex> findVerticiesWithNoIncomingEdge(Map<Vertex, List<Vertex>> incomingEdges) {
        Stack<Vertex> noIncomingEdges = new Stack<>();
        for (Vertex v : graph) {
            if (incomingEdges.get(v).size() == 0)
                noIncomingEdges.push(v);
        }
        return noIncomingEdges;
    }

    @Override
    public List<List<Integer>> connectedComponents() {
        SCCAlgoImpl g = new SCCAlgoImpl(graph, outgoingEdges, incomingEdges);
        return g.run();
    }
}
