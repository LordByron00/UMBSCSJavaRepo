package DiscreteMath.dump.b;

import java.util.Scanner;

public class DijkstraShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int V = scanner.nextInt();
        Graph graph = new Graph(V);

        // Assuming a tree structure, so each node except the root has one parent
        for (int i = 2; i <= V; ++i) {
            System.out.println("Enter edge details (parent, child, weight) for node " + i + ": ");
            int parent = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(parent, i, weight);
        }

        System.out.print("Enter the source node: ");
        int sourceNode = scanner.nextInt();

        graph.shortestPath(sourceNode);

        scanner.close();
    }
}