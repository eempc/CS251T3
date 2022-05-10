package com.meow;

/*
Adjacency list structure is the simplest, just a list of nodes, and then have a HashMap,
with the source node and a list of its connected nodes
It does not have a list of edges and is thus generally useless for an efficient weighted traversal
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class AdjacencyListStructure {
    private HashMap<Node, LinkedList<Node>> adjacencyMap; // I don't think this necessarily needs to be a LinkedList, also do not mistake this for the Adj Map structure
    private boolean directed;

    public AdjacencyListStructure(boolean directed) {
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    public void addEdge(Node source, Node destination) {
        // If neither source nor dest exist, put them in, this should be a helper method
        if (!adjacencyMap.containsKey(source)) {
            adjacencyMap.put(source, null);
        }

        if (!adjacencyMap.containsKey(destination)) {
            adjacencyMap.put(destination, null);
        }

        addEdgeHelper(source, destination);

        // If undirected, you need to add the other direction as well, so technically there are two edges for the same two nodes
        if (!directed) {
            addEdgeHelper(destination, source);
        }
    }

    private void addEdgeHelper(Node a, Node b) {
        LinkedList<Node> temp = adjacencyMap.get(a);
        if (temp != null) {
            temp.remove(b);
        } else {
            temp = new LinkedList<>();
        }
        temp.add(b);
        adjacencyMap.put(a, temp);
    }

    public void printEdges() {
        for (Node node : adjacencyMap.keySet()) {
            System.out.println("Name " + node.getName() + " has following edges towards: ");
            for (Node n : adjacencyMap.get(node)) {
                System.out.println(n.getName() + " ");
            }
        }
    }

    public Set<Node> getNodes() {
        return adjacencyMap.keySet();
    }

    public boolean hasEdge(Node source, Node destination) {
        // Does linked list .contains() destination node?
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source).contains(destination);
    }

    // DFS starting at a target source, and utilising the visit booleans
    public void dfs(Node target) {
        // 1. Visit and do action
        target.visit(); // set isVisited to true
        System.out.println(target.getName()); // Action

        // 2.  Get list of this node's neighbours and check is not null
        LinkedList<Node> allNeighbours = adjacencyMap.get(target); // Since get() will get a LL<Node> of the neighbours due to the HashMap
        if (allNeighbours == null)
            return;

        // 3. Traverse through each neighbour node, if the neighbour has not been visited, recur through it
        for (Node n : allNeighbours) {
            if (!n.isVisited()) {
                dfs(n);
            }
        }
    }

    // For BFS, you need a linked list queue structure, FIFO
    // NQW FCVNT
    public void bfs(Node node) {
        // 1. N = Check input node is not null
        if (node == null) return;

        // 2 Q = Create a queue and add the (first) node
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        // 3. W = Start while loop
        while (!queue.isEmpty()) {
            // 4. F = Remove and return the first node
            Node current = queue.removeFirst();

            // 5. C = If it has been visited, continue, i.e. skip the rest of the code inside the while loop
            if (current.isVisited()) {
                continue;
            }

            // 6. V = Else do the rest - Visit and action
            current.visit();
            System.out.println(current.getName());

            // 7. N = Then get the neighbours and check is not null, then traverse
            LinkedList<Node> allNeighbours = adjacencyMap.get(current);
            if (allNeighbours == null)
                continue;

            // 8. T = If the neighbouring node has not been visited, add it to the queue
            for (Node n : allNeighbours) {
                if (!n.isVisited()) {
                    queue.add(n); // Add to queue
                }
            }
        }
    }

    public static void main(String[] args) {
        // Input is an adjacency matrix // Construct a graph from that
        int[][] input = {
                {0,0,0,0,1,0,0,0},
                {0,0,0,1,0,1,0,0},
                {1,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0},
                {0,1,0,1,0,0,0,0},
                {0,0,0,0,0,1,0,1},
                {0,0,0,0,0,1,0,0},
        };

        AdjacencyListStructure graph = new AdjacencyListStructure(false);
        Node[] eightNodes = new Node[8];

        for (int i = 0; i < input.length; i++) {
            eightNodes[i] = new Node(i, "Name: " + i);
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                 if (input[i][j] == 1) {
                    graph.addEdge(eightNodes[i], eightNodes[j]);
                }
            }
        }

        graph.dfs(eightNodes[0]);

        int[][] input2 = {
                {0,0,1,1,1,0,0,0},
                {1,0,1,1,0,1,0,0},
                {0,0,0,0,0,1,1,0},
                {0,1,0,0,0,0,0,1},
                {0,0,1,0,0,0,0,0},
                {0,1,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0}
        };

        AdjacencyListStructure graph2 = new AdjacencyListStructure(true);
        Node[] eightNodes2 = new Node[8];

        for (int i = 0; i < input2.length; i++) {
            eightNodes2[i] = new Node(i, "Nombre: " + i);
        }

        for (int i = 0; i < input2.length; i++) {
            for (int j = 0; j < input2[i].length; j++) {
                if (input2[i][j] == 1) {
                    graph2.addEdge(eightNodes2[i], eightNodes2[j]);
                }
            }
        }

        graph2.bfs(eightNodes2[0]);

        int[][] input3 = {
                {0,0,1,0,0,1,0,0,0},
                {0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,0},
                {0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0},
        };

        AdjacencyListStructure graph3 = new AdjacencyListStructure(true);
        Node[] nineNodes = new Node[9];

        for (int i = 0; i < input3.length; i++) {
            nineNodes[i] = new Node(i, "No.: " + i);
        }

        for (int i = 0; i < input3.length; i++) {
            for (int j = 0; j < input3[i].length; j++) {
                if (input3[i][j] == 1) {
                    graph3.addEdge(nineNodes[i], nineNodes[j]);
                }
            }
        }

        GraphClosure.transitiveClosure(input3);
    }
}


