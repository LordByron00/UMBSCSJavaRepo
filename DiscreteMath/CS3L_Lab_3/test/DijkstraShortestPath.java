package DiscreteMath.CS3L_Lab_3.test;

import java.util.*;


public class DijkstraShortestPath {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        // Input the number of nodes
        System.out.print("Number of nodes: ");
        int numNodes = io.nextInt();

        // Create an adjacency list to represent the graph
        Map<Integer, Map<Integer, Integer>> node = new HashMap<>();
        for (int i = 1; i <= numNodes; i++) {
            System.out.print("Number of edges for node " + i + ": ");
            int numEdges;
            do {
                numEdges = io.nextInt();
            } while (numEdges > numNodes);
            Map<Integer, Integer> edges = new HashMap<>();
            for (int j = 0; j < numEdges; j++) {
                System.out.print("Connected node for edge " + (j + 1) + ": ");
                int connectedNode = io.nextInt();
                System.out.print("Weight for edge " + (j + 1) + ": ");
                int weight = io.nextInt();
                edges.put(connectedNode, weight);
            }
            node.put(i, edges);
        }
        System.out.println("================Network of Nodes and Edges===================");
        showGraph(node);

        int source_Node;
        do {
            System.out.println("Enter the Source Node: ");
            source_Node = io.nextInt();
        }
        while(source_Node > numNodes);

        Map<Integer, Map<Integer, Integer>> shortestPath = new LinkedHashMap<>();

        int nextNode = source_Node;
        // Loop through the graph map
        while (!node.isEmpty()) {
//            System.out.println("Current nodes: " + node);
            int current_Node = nextNode;
            if (node.containsKey(nextNode)) {
                Map<Integer, Integer> edges =  node.get(nextNode);
                if (!edges.isEmpty()) {
//                    System.out.println("Current element: " + edges);
                    Map<Integer, Integer> innerEdgeTemp = new HashMap<>();
                    int tempKey = 0;
                    for (Map.Entry<Integer, Integer> innerEntry : edges.entrySet()) {
                        int innerKey = innerEntry.getKey();
                        int innerValue = innerEntry.getValue();
                        if (node.containsKey(innerKey)) {
                            if (innerEdgeTemp.isEmpty()) {
                                innerEdgeTemp.put(innerKey, innerValue);
                                nextNode = innerKey;
                                tempKey = innerKey;
                            } else {
                                if (innerValue < innerEdgeTemp.get(tempKey)) {
                                    innerEdgeTemp.clear();
                                    nextNode = innerKey;
                                    innerEdgeTemp.put(innerKey, innerValue);
                                    tempKey = innerKey;
                                }
                            }
                        }
                    }
                    if (!innerEdgeTemp.isEmpty()) {
                        shortestPath.put(current_Node, innerEdgeTemp);

                    }
                    node.remove(current_Node);
                }
            } else {
                node.clear();
            }
        }
        System.out.println("**************Shortest Path***************");
        showGraph(shortestPath);
    }

    static void showGraph(Map<Integer, Map<Integer, Integer>> graph) {
        int totalWeight = 0;
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : graph.entrySet()) {
            int origin = entry.getKey();
            Map<Integer, Integer> short_Edge = entry.getValue();
            for (Map.Entry<Integer, Integer> innerEntry : short_Edge.entrySet()) {
                int destination = innerEntry.getKey();
                int weight = innerEntry.getValue();
                totalWeight += weight;
                System.out.println("Node-" + origin + " --(weight:" + weight + ")--> " + "Node-" + destination);
            }
        }
        System.out.println("Total Weight: " + totalWeight);
    }

}


//for (Map.Entry<Integer, Map<Integer, Integer>> entry : node.entrySet()) {
//        int nodeKey = entry.getKey();
//        if (nextNode == nodeKey) {
//        Map<Integer, Integer> innerMap = entry.getValue();
//        Map<Integer, Integer> innerEdgeTemp = new HashMap<>();
//        int tempKey = 0;
//        for (Map.Entry<Integer, Integer> innerEntry : innerMap.entrySet()) {
//        int innerKey = innerEntry.getKey();
//        int innerValue = innerEntry.getValue();
//
//        if (innerEdgeTemp.isEmpty()) {
//        innerEdgeTemp.put(innerKey, innerValue);
//        nextNode = innerKey;
//        } else {
//        if (innerValue < innerEdgeTemp.get(tempKey)) {
//        innerEdgeTemp.clear();
//        nextNode = innerKey;
//        innerEdgeTemp.put(innerKey, innerValue);
//        }
//        }
//        tempKey = innerKey;
//        }
//        shortestPath.put(nodeKey, innerEdgeTemp);
//        }
//        }
//        //Removing the nodes that have been iterated.
//        for (Map.Entry<Integer, Map<Integer, Integer>> removeEntry : shortestPath.entrySet()) {
//        int unNode = removeEntry.getKey();
//        node.remove(unNode);
//        }

//class Node {
//    int node;
//    int edgeNum;
//    int weight;
//    ArrayList<Edge> edges;
//
//    Node(int node, int weight, int edgeNum, ArrayList<Edge> edges) {
//        this.node = node;
//        this.weight = weight;
//        this.edgeNum = edgeNum;
//        this.edges = edges;
//    }
//
//    void set_Edges(ArrayList<Edge> edges) {
//        this.edges = edges;
//    }
//}
//
//class Edge {
//    Node source;
//    Node dest;
//    int weight;
//
//    Edge(Node source, Node dest, int weight) {
//        this.source = source;
//        this.dest = dest;
//        this.weight = weight;
//    }
//}