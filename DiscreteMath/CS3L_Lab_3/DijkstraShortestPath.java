package DiscreteMath.CS3L_Lab_3;
import java.util.*;

public class DijkstraShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of nodes
        System.out.print("Enter the number of nodes: ");
        int numNodes = scanner.nextInt();

        // Create an adjacency list to represent the graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 1; i <= numNodes; i++) {
            System.out.print("Enter the number of edges for node " + i + ": ");
            int numEdges = scanner.nextInt();
            Map<Integer, Integer> edges = new HashMap<>();
            for (int j = 0; j < numEdges; j++) {
                System.out.print("Enter the connected node and edge weight for edge " + (j + 1) + ": ");
                int connectedNode = scanner.nextInt();
                int weight = scanner.nextInt();
                edges.put(connectedNode, weight);
            }
            graph.put(i, edges);
        }

        // Input the source node
        System.out.print("Enter the source node: ");
        int sourceNode = scanner.nextInt();

        // Perform Dijkstra's Shortest Path Algorithm
        Map<Integer, Integer> shortestDistances = new HashMap<>();
        shortestDistances.put(sourceNode, 0);
        Map<Integer, List<Integer>> shortestPaths = new HashMap<>();

        for (int i = 1; i <= numNodes; i++) {
            if (i != sourceNode) {
                shortestDistances.put(i, Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(numNodes, new NodeComparator());
        priorityQueue.add(new Node(sourceNode, 0));

        while (!priorityQueue.isEmpty()) {
            int currentNode = priorityQueue.poll().node;
            Map<Integer, Integer> neighbors = graph.get(currentNode);

            for (int neighbor : neighbors.keySet()) {
                int distanceToNeighbor = shortestDistances.get(currentNode) + neighbors.get(neighbor);
                if (distanceToNeighbor < shortestDistances.get(neighbor)) {
                    shortestDistances.put(neighbor, distanceToNeighbor);

                    List<Integer> shortestPath = new ArrayList<>(shortestPaths.getOrDefault(currentNode, Collections.emptyList()));
                    shortestPath.add(currentNode);
                    shortestPaths.put(neighbor, shortestPath);

                    priorityQueue.add(new Node(neighbor, distanceToNeighbor));
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
}

class Node {
    int node;
    int distance;

    Node(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class NodeComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.distance - b.distance;
    }
}
