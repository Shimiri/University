import assignment3.MySocialNetwork;
import org.junit.jupiter.api.Test;

public class MySocialNetworkTests {
    @Test
    public void testNumberOfPeopleAtFriendshipDistance() {
        MySocialNetwork msn = new MySocialNetwork();
        msn.addVertex(1);
        msn.addVertex(2);
        msn.addVertex(3);
        msn.addVertex(4);
        msn.addVertex(5);
        msn.addVertex(6);
        msn.addVertex(7);
        msn.addVertex(8);
        msn.addVertex(9);
        msn.addVertex(10);
        msn.addVertex(11);
        msn.addVertex(12);
        msn.addVertex(13);
        msn.addVertex(14);
        msn.addVertex(15);
        msn.addEdge(1, 5);
        msn.addEdge(1, 2);
        msn.addEdge(1, 4);
        msn.addEdge(1, 3);
        msn.addEdge(2, 5);
        msn.addEdge(2, 4);
        msn.addEdge(2, 3);
        msn.addEdge(3, 4);
        msn.addEdge(3, 6);
        msn.addEdge(3, 13);
        msn.addEdge(4, 5);
        msn.addEdge(5, 6);
        msn.addEdge(5, 15);
        msn.addEdge(5, 12);
        msn.addEdge(5, 9);
        msn.addEdge(5, 8);
        msn.addEdge(5, 7);
        msn.addEdge(6, 14);
        msn.addEdge(7, 11);
        msn.addEdge(7, 10);
        msn.addEdge(8, 10);
        msn.addEdge(9, 10);

        int numberOfFriends = msn.numberOfPeopleAtFriendshipDistance(5, 2);
        System.out.println(numberOfFriends);
    }

    @Test
    public void testFurthestDistanceInFriendshipRelationships() {
        MySocialNetwork msn = new MySocialNetwork();
        msn.addVertex(1);
        msn.addVertex(2);
        msn.addVertex(3);
        msn.addVertex(4);
        msn.addVertex(5);
        msn.addVertex(6);
        msn.addVertex(7);
        msn.addVertex(8);
        msn.addVertex(9);
        msn.addVertex(10);
        msn.addVertex(11);
        msn.addVertex(12);
        msn.addVertex(13);
        msn.addVertex(14);
        msn.addVertex(15);
        msn.addEdge(1, 5);
        msn.addEdge(1, 2);
        msn.addEdge(1, 4);
        msn.addEdge(1, 3);
        msn.addEdge(2, 5);
        msn.addEdge(2, 4);
        msn.addEdge(2, 3);
        msn.addEdge(3, 4);
        msn.addEdge(3, 6);
        msn.addEdge(3, 13);
        msn.addEdge(4, 5);
        msn.addEdge(5, 6);
        msn.addEdge(5, 15);
        msn.addEdge(5, 12);
        msn.addEdge(5, 9);
        msn.addEdge(5, 8);
        msn.addEdge(5, 7);
        msn.addEdge(6, 14);
        msn.addEdge(7, 11);
        msn.addEdge(7, 10);
        msn.addEdge(8, 10);
        msn.addEdge(9, 10);

        int furthestDistance = msn.furthestDistanceInFriendshipRelationships(1);
        System.out.println(furthestDistance);
    }
}
