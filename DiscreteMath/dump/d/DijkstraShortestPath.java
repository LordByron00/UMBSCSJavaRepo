package DiscreteMath.dump.d;

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

        // Initialize data structures for the modified Dijkstra's algorithm
        Map<Integer, Integer> shortestDistances = new HashMap<>();
        Map<Integer, List<Integer>> shortestPaths = new HashMap<>();
        Set<Integer> visitedNodes = new HashSet<>();

        for (int i = 1; i <= numNodes; i++) {
            shortestDistances.put(i, i == 1 ? 0 : Integer.MAX_VALUE);
        }

        // Perform the modified Dijkstra's Shortest Path Algorithm
        while (visitedNodes.size() < numNodes) {
            int currentNode = findNextNodeToVisit(shortestDistances, visitedNodes);
            visitedNodes.add(currentNode);

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
            if (i != 1) {
                System.out.println("Shortest Path from Node 1 to Node " + i + ":");
                System.out.println("Total Weight: " + shortestDistances.get(i));
                System.out.println("Nodes in the Shortest Path: " + shortestPaths.get(i));
            }
        }

        scanner.close();
    }

    // Helper method to find the next unvisited node with the minimum distance
    private static int findNextNodeToVisit(Map<Integer, Integer> shortestDistances, Set<Integer> visitedNodes) {
        int minNode = -1;
        int minDistance = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : shortestDistances.entrySet()) {
            int node = entry.getKey();
            int distance = entry.getValue();
            if (!visitedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
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
