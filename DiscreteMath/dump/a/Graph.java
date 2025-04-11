package DiscreteMath.dump.a;
import java.util.*;
class Graph {
    private int V; // Number of vertices/nodes
    private LinkedList<Edge>[] adj; // Adjacency List for edges

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        adj[src].add(edge);
    }

    // Dijkstra's Shortest Path Algorithm
    public void shortestPath(int src) {
        int[] dist = new int[V]; // Shortest distance from source
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(V, new NodeComparator());
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().node;

            for (Edge e : adj[u]) {
                int v = e.dest;
                int weight = e.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Print shortest paths and total weight
        for (int i = 0; i < V; ++i) {
            System.out.println("Shortest Path from Node " + src + " to Node " + i + ": " + dist[i]);
        }
    }
}

class Edge {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
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

