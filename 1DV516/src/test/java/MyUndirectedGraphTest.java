import assignment3.MyUndirectedGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MyUndirectedGraphTest {
    @Test
    public void TestAddVertex() {

    }

    @Test
    public void TestAddEdge() {
        MyUndirectedGraph g = new MyUndirectedGraph();
        g.addVertex(5);
        g.addVertex(10);
        g.addVertex(15);
        g.addEdge(5, 10);
        g.addEdge(5, 15);
    }

    @Test
    public void testIsAcyclicFalse() {
        MyUndirectedGraph g = new MyUndirectedGraph();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(10);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(5, 10);
        Assertions.assertFalse(g.isAcyclic());
    }

    @Test
    public void testIsAcyclicTrue() {
        MyUndirectedGraph g = new MyUndirectedGraph();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        Assertions.assertTrue(g.isAcyclic());
    }

    @Test
    public void testIsConnected() {
        MyUndirectedGraph g = new MyUndirectedGraph();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        Assertions.assertTrue(g.isConnected());
    }

    @Test
    public void testConnectedComponents() {
        MyUndirectedGraph g = new MyUndirectedGraph();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println(Arrays.toString(g.connectedComponents().toArray()));
    }

    @Test
    public void testEulerPath() {
        MyUndirectedGraph g = new MyUndirectedGraph();
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(0, 1);
        boolean hasEulerPath = g.hasEulerPath();
        System.out.println("euler path: " + hasEulerPath);

        g = new MyUndirectedGraph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addEdge(1, 5);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 3);
        g.addEdge(3, 5);

        hasEulerPath = g.hasEulerPath();
        System.out.println("euler path: " + hasEulerPath);
    }
}
