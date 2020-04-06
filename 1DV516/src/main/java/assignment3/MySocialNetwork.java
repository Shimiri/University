package assignment3;

import java.util.*;

public class MySocialNetwork extends MyUndirectedGraph implements assignment3AADS.assignment3.A3SocialNetwork {

    @Override
    public int numberOfPeopleAtFriendshipDistance(int vertexIndex, int distance) {
        Set<Vertex> friends = new HashSet<>();
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex start = vertices.stream().filter(v -> v.getItem() == vertexIndex).findFirst().get();

        queue.add(start);
        visited.add(start);

        int depth = 0;
        int depthIncrease = 1;
        Set<Vertex> nextDepthIncrease = new HashSet<>();
        while (queue.size() != 0) {
            Vertex v = queue.poll();

            if (distance == depth)
                friends.add(v);

            List<Vertex> adj = adjacentVertices.get(v);
            for (Vertex a : adj) {
                if (!visited.contains(a)) {
                    nextDepthIncrease.add(a);
                }
            }

            depthIncrease -= 1;
            if (depthIncrease == 0) {
                depth += 1;
                if (depth > distance)
                    return friends.size();
                depthIncrease = nextDepthIncrease.size();
                nextDepthIncrease = new HashSet<>();
            }

            List<Vertex> children = adjacentVertices.get(v);
            for (Vertex child : children) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(child);
                }
            }
        }
	    return friends.size();
    }

    @Override
    public int furthestDistanceInFriendshipRelationships(int vertexIndex) {
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex start = vertices.stream().filter(v -> v.getItem() == vertexIndex).findFirst().get();

        queue.add(start);
        visited.add(start);

        int depth = 0;
        int depthIncrease = 1;
        Set<Vertex> nextDepthIncrease = new HashSet<>();
        while (queue.size() != 0) {
            Vertex v = queue.poll();

            List<Vertex> adj = adjacentVertices.get(v);
            for (Vertex a : adj) {
                if (!visited.contains(a)) {
                    nextDepthIncrease.add(a);
                }
            }

            depthIncrease -= 1;
            if (depthIncrease == 0) {
                depth += 1;
                depthIncrease = nextDepthIncrease.size();
                nextDepthIncrease = new HashSet<>();
            }

            List<Vertex> children = adjacentVertices.get(v);
            for (Vertex child : children) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(child);
                }
            }
        }
        return depth - 1;
    }

    @Override
    public List<Integer> possibleFriends(int vertexIndex) {
	// TODO Auto-generated method stub
	return null;
    }

}
