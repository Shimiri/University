package assignment3;

import assignment3AADS.assignment3.A3Graph;

import java.util.*;

public class MyUndirectedGraph implements A3Graph {
    protected final Map<Vertex, List<Vertex>> adjacentVertices = new HashMap<>();
    protected final List<Vertex> vertices = new ArrayList<>();

    @Override
    public void addVertex(int vertex) {
        vertices.add(new Vertex(vertex));
        adjacentVertices.putIfAbsent(new Vertex(vertex), new ArrayList<>());
    }

    @Override
    public void addEdge(int sourceVertex, int targetVertex) {
        Vertex source = new Vertex(sourceVertex);
        Vertex target = new Vertex(targetVertex);
        adjacentVertices.get(source).add(target);
        adjacentVertices.get(target).add(source);
    }

    @Override
    public boolean isConnected() {
	    for (Vertex v : vertices) {
	        Set<Vertex> visited = depthTraversal(v);
	        if (visited.size() != vertices.size())
	            return false;
        }
	    return true;
    }

    @Override
    public boolean isAcyclic() {
        Set<Vertex> visited = new HashSet<>();

        for (Vertex vertex : vertices) {
            if (!visited.contains(vertex)) {
                if (graphHasCycle(vertex, null, visited)) {
                    return false;
                }
            }
        }
	    return true;
    }

    private boolean graphHasCycle(Vertex vertex, Vertex parent, Set<Vertex> visited) {
        visited.add(vertex);
        List<Vertex> adjVerticies = adjacentVertices.get(vertex);
        for (Vertex adjVertex : adjVerticies) {
            if (!visited.contains(adjVertex)) {
                if (graphHasCycle(adjVertex, vertex, visited)) {
                    return true;
                }
            } else if (!adjVertex.equals(parent)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<List<Integer>> connectedComponents() {
        List<List<Integer>> components = new ArrayList<>();
	    Set<Vertex> visited = new HashSet<>();
	    for (Vertex v : vertices) {
	        if (!visited.contains(v)) {
	            visited.add(v);
	            Set<Vertex> component = depthTraversal(v);

	            List<Integer> integerComponent = new ArrayList<>();
	            for (Vertex u : component) {
                    visited.add(u);
                    integerComponent.add(u.getItem());
                }

	            components.add(integerComponent);
            }
        }
	    return components;
    }

    @Override
    public boolean hasEulerPath() {
        List<Integer> potentialEulerPath = eulerPath();
        if (potentialEulerPath.size() == 0)
            return false;

        int start = eulerPath().get(0);
        int endOfList = potentialEulerPath.size() - 1;
        for (int i = endOfList; i >= 1; i--) {
            int current = potentialEulerPath.get(i);
            if (start == current)
                return true;
        }
        return false;
    }

    @Override
    public List<Integer> eulerPath() {
        List<Vertex> oddDegreeVerticies = new ArrayList<>();
        for (Vertex v : vertices) { // O(V)
            if (adjacentVertices.get(v).size() % 2 == 1) {
                oddDegreeVerticies.add(v);
            }
        }

        if (oddDegreeVerticies.size() != 0 && oddDegreeVerticies.size() != 2)
            return new ArrayList<>();

        Vertex start = oddDegreeVerticies.size() == 0 ? vertices.get(0) : oddDegreeVerticies.get(0);
        List<Vertex[]> edges = buildEdges(); // O(V * Neighbors * Edges)

        List<Integer> eulerPath = new ArrayList<>();

        Stack<Vertex> unvisited = new Stack<>();
        unvisited.push(start);
        while (!unvisited.empty()) {
            Vertex v = unvisited.pop();
            List<Vertex[]> neighbors = findNeighbors(v, edges); // O(V)
            for (Vertex[] neighbor : neighbors) { // O(V)
                Vertex adjacentVertex = getNeighbor(neighbor, v);
                if (adjacentVertices.get(adjacentVertex).size() == 1) {
                    eulerPath.add(v.getItem());
                    removeEdge(neighbor, edges);
                    continue;
                }
                unvisited.push(adjacentVertex);
                eulerPath.add(v.getItem());
                removeEdge(neighbor, edges);
                break;
            }
        }
        return eulerPath;
    }

    private void removeEdge(Vertex[] neighbor, List<Vertex[]> edges) {
        edges.remove(neighbor);
    }

    private Vertex getNeighbor(Vertex[] neighbor, Vertex v) {
        if (neighbor[0].equals(v))
            return neighbor[1];
        return neighbor[0];
    }

    private List<Vertex[]> findNeighbors(Vertex v, List<Vertex[]> edges) {
        List<Vertex[]> neighbors = new ArrayList<>();
        for (Vertex[] edge : edges) {
            if (edge[0].equals(v) || edge[1].equals(v)) {
                neighbors.add(edge);
            }
        }
        return neighbors;
    }

    private List<Vertex[]> buildEdges() {
        List<Vertex[]> edges = new ArrayList<>();
        for (Vertex v : vertices) { // O(V)
            List<Vertex> neighbors = adjacentVertices.get(v);
            for (Vertex neighbor : neighbors) { // O(E)
                Vertex[] edge = new Vertex[] {v, neighbor};
                if (!edgeAlreadyExists(edge, edges)) { // O(Edges)
                    edges.add(edge);
                }
            }
        }
        return edges;
    }

    private boolean edgeAlreadyExists(Vertex[] target, List<Vertex[]> edges) {
        if (edges.size() == 0)
            return false;
        for (Vertex[] edge : edges) {
            if (edge[0].equals(target[1]) && edge[1].equals(target[0])) {
                return true;
            }
        }
        return false;
    }

    private Set<Vertex> depthTraversal(Vertex first) {
        Set<Vertex> visited = new LinkedHashSet<>();
        Stack<Vertex> vertexStack = new Stack<>();
        vertexStack.push(first);
        while (!vertexStack.isEmpty()) {
            Vertex v = vertexStack.pop();

            if (!visited.contains(v)) {
                visited.add(v);
                for (Vertex u : adjacentVertices.get(v)) {
                    vertexStack.push(u);
                }
            }
        }
        return visited;
    }
}
