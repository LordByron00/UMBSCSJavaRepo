package DiscreteMath.dump.b;
import java.util.*;

class Graph {
    private int V; // Number of vertices
    private Map<Integer, List<Edge>> adj; // Adjacency List for edges

    public Graph(int v) {
        V = v;
        adj = new HashMap<>();
        for (int i = 1; i <= v; ++i) {
            adj.put(i, new ArrayList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(src, dest, weight);
        adj.get(src).add(edge);

        // For an undirected graph, you might want to add the reverse edge as well.
        // adj.get(dest).add(new Edge(src, weight));
    }

    // Dijkstra's Shortest Path Algorithm
    public void shortestPath(int src) {
        int[] dist = new int[V + 1]; // Shortest distance from source
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(V, new NodeComparator());
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().node;

            for (Edge e : adj.get(u)) {
                int v = e.dest;
                int weight = e.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Print shortest paths and total weight
        for (int i = 1; i <= V; ++i) {
            System.out.println("Shortest Path from Node " + src + " to Node " + i + ": " + dist[i]);
        }
    }
}

class Edge {
    int dest;
    int weight;

    Edge(int dest, int weight, int i) {
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

