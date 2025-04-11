package DiscreteMath.dump.c;

import java.util.*;

public class DijkstraShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of nodes
        System.out.print("Enter the number of nodes: ");
        int numNodes = scanner.nextInt();

        // Create an adjacency list to represent the graph
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= numNodes; i++) {
            System.out.print("Enter the number of edges for node " + i + ": ");
            int numEdges = scanner.nextInt();
            List<Edge> edges = new ArrayList<>();
            for (int j = 0; j < numEdges; j++) {
                System.out.print("Enter the source, destination, and weight for edge " + (j + 1) + ": ");
                int source = scanner.nextInt();
                int destination = scanner.nextInt();
                int weight = scanner.nextInt();
                edges.add(new Edge(source, destination, weight));
            }
            graph.put(i, edges);
        }

        // Input the source node
        System.out.print("Enter the source node: ");
        int sourceNode = scanner.nextInt();

        // Initialize data structures for Dijkstra's algorithm
        Map<Integer, Integer> shortestDistances = new HashMap<>();
        Map<Integer, List<Integer>> shortestPaths = new HashMap<>();
        Set<Integer> unvisitedNodes = new HashSet<>();

        for (int i = 1; i <= numNodes; i++) {
            shortestDistances.put(i, i == sourceNode ? 0 : Integer.MAX_VALUE);
            unvisitedNodes.add(i);
        }

        // Perform Dijkstra's Shortest Path Algorithm
        while (!unvisitedNodes.isEmpty()) {
            int currentNode = findNodeWithMinDistance(unvisitedNodes, shortestDistances);
            unvisitedNodes.remove(currentNode);

            for (Edge edge : graph.getOrDefault(currentNode, Collections.emptyList())) {
                int neighbor = edge.destination;
                int newDistance = shortestDistances.get(currentNode) + edge.weight;

                if (newDistance < shortestDistances.get(neighbor)) {
                    shortestDistances.put(neighbor, newDistance);
                    List<Integer> shortestPath = new ArrayList<>(shortestPaths.getOrDefault(currentNode, Collections.emptyList()));
                    shortestPath.add(currentNode);
                    shortestPaths.put(neighbor, shortestPath);
                }
            }
        }

        // Display the total weight of the shortest path and nodes in the shortest path for each node
        for (int i = 1; i <= numNodes; i++) {
            if (i != sourceNode) {
                System.out.println("Shortest Path from Node " + sourceNode + " to Node " + i + ":");
                System.out.println("Total Weight: " + shortestDistances.get(i));
                System.out.println("Nodes in the Shortest Path: " + shortestPaths.get(i));
            }
        }

        scanner.close();
    }

    // Helper method to find the unvisited node with the minimum distance
    private static int findNodeWithMinDistance(Set<Integer> unvisitedNodes, Map<Integer, Integer> shortestDistances) {
        int minNode = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int node : unvisitedNodes) {
            int distance = shortestDistances.get(node);
            if (distance < minDistance) {
                minDistance = distance;
                minNode = node;
            }
        }

        return minNode;
    }
}

class Edge {
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
