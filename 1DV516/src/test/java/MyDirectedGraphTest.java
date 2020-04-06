import assignment3.MyDirectedGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyDirectedGraphTest {
    @Test
    public void testAddEdge() {
        MyDirectedGraph g = new MyDirectedGraph();
        g.addVertex(5);
        g.addVertex(10);
        g.addEdge(5, 10);
    }

    @Test
    public void testIsAcyclic() {
        MyDirectedGraph g = new MyDirectedGraph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(1, 3);
        g.addEdge(3, 2);
        g.addEdge(1, 4);
        Assertions.assertTrue(g.isAcyclic());
    }

    @Test
    public void testConnectedComps() {
        MyDirectedGraph g = new MyDirectedGraph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addEdge(1, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 1);
        g.addEdge(1, 4);
        List<List<Integer>> comps = g.connectedComponents();
    }

    @Test
    public void testIsConnected() {
        MyDirectedGraph g = new MyDirectedGraph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addEdge(1, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 1);
        boolean connected = g.isConnected();
    }
}
