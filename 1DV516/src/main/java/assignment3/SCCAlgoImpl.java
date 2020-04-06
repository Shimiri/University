package assignment3;

import java.util.*;

public class SCCAlgoImpl {
    private final Map<Vertex, List<Vertex>> incomingEdges;
    private final Map<Vertex, List<Vertex>> outgoingEdges;
    private final Map<Vertex, Integer> denominators = new HashMap<>();
    private final Map<Vertex, Integer> numerators = new HashMap<>();
    private final List<Vertex> vertices;
    private Set<Vertex> visited = new HashSet<>();
    private Integer numerator = 1;
    private Integer denominator;

    public SCCAlgoImpl(List<Vertex> vertices,
                       Map<Vertex, List<Vertex>> outgoingEdges,
                       Map<Vertex, List<Vertex>> incomingEdges) {
        this.outgoingEdges = outgoingEdges;
        this.incomingEdges = incomingEdges;
        this.vertices = vertices;
    }

    public List<List<Integer>> run() {
        for (Iterator<Vertex> it = vertices.iterator(); it.hasNext();) { // O(V)
            Vertex v = it.next();
            if (!numerators.containsKey(v))
                algo(v); // O(V + E)
        }

        for (Vertex v : vertices) { // O(V)
            reverseEdge(v); // O(E)3
        }

        List<List<Integer>> sccs = new ArrayList<>();
        Vertex[] sortedDenominators = sortByValue(denominators).keySet().toArray(new Vertex[0]); // O(N * Log(N))
        visited = new HashSet<>();
        for (int i = sortedDenominators.length - 1; i >= 0; i--) { // O(N)
            Vertex v = sortedDenominators[i];
            if (!visited.contains(v))
                sccs.add(algo(v)); // O(V + E)
        }
        return sccs;
    }

    public void reverseEdge(Vertex source) { //O(E)
        List<Vertex> tempIncomingEdges = List.copyOf(incomingEdges.get(source));
        List<Vertex> tempOutgoingEdges = List.copyOf(outgoingEdges.get(source));

        incomingEdges.get(source).clear();
        outgoingEdges.get(source).clear();

        incomingEdges.get(source).addAll(tempOutgoingEdges);
        outgoingEdges.get(source).addAll(tempIncomingEdges);
    }

    private List<Integer> algo(Vertex root) { //O(V + E)
        List<Integer> scc = new ArrayList<>();
        List<Vertex> noDenominatorVerticies = new ArrayList<>();
        Stack<Vertex> vertexStack = new Stack<>();
        vertexStack.push(root);
        while (!vertexStack.isEmpty()) { // O(V)
            Vertex v = vertexStack.pop();
            if (!visited.contains(v)) {
                noDenominatorVerticies.add(v);
                visited.add(v);
                scc.add(v.getItem());
                for (Vertex u : outgoingEdges.get(v)) { //O(E)
                    vertexStack.push(u);
                }
            }

            if (!numerators.containsKey(v)) {
                numerators.put(v, (numerator++));
                denominator = numerator;
            }

            boolean deadEnd = true;
            for (Vertex u : outgoingEdges.get(v)) { //O(E)
                if (!visited.contains(u)) {
                    deadEnd = false;
                    break;
                }
            }

            if (deadEnd) {
                if (!denominators.containsKey(v)) {
                    denominators.put(v, (denominator++));
                    numerator = denominator;
                    noDenominatorVerticies.remove(v);
                }
            }
        }

        for (int i = noDenominatorVerticies.size() - 1; i >= 0; i--) { //O(NDV - V)
            Vertex v = noDenominatorVerticies.get(i);
            denominators.put(v, denominator++);
        }
        numerator = denominator;
        return scc;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) { // O(N * Log(N))
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue()); // O(N * Log(N))

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) { // O(N)
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
