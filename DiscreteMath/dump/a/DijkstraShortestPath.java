package DiscreteMath.dump.a;

import java.util.Scanner;

public class DijkstraShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int V = scanner.nextInt();
        Graph graph = new Graph(V);

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        for (int i = 0; i < E; ++i) {
            System.out.println("Enter edge " + (i + 1) + " details (source, destination, weight): ");
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(src, dest, weight);
        }

        System.out.print("Enter the source node: ");
        int sourceNode = scanner.nextInt();

        graph.shortestPath(sourceNode);

        scanner.close();
    }
}