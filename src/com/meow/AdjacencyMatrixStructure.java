package com.meow;

import java.util.ArrayList;

// The matrix is being reported as a 2D array in the textbook where the index represents the node,
// which means Nodes has to be an ordered List<> of some sort
// Technically extends EdgeList, you can do super(overrides with addEdge)
public class AdjacencyMatrixStructure {
    private ArrayList<Node> nodes = new ArrayList<>(); // Can be inherited
    private Arc[][] matrix; // could be a boolean[][] or int[][] 1/0 if unweighted and bidirectional
    private ArrayList<ArrayList<Arc>> matrix2 = new ArrayList<>(); // Don't do this

    public AdjacencyMatrixStructure(int size) {
        this.matrix = new Arc[size][size];
    }

    public void addNode(Node n) {
        nodes.add(n); // Assume node isn't already present, each node needs a unique id field
    }

    // This should be an override if inheriting
    public void addEdge(int src, int dest) {
        Arc temp = new Arc(nodes.get(src), nodes.get(dest));
        //temp.setSource(nodes.get(src)); // Optional check exists
        //temp.setDestination(nodes.get(dest)); // Optional check exists
        matrix[src][dest] = temp;
        matrix2.get(src).add(dest, temp);
        // If extending, add temp to the arcList of the EdgeList super class
    }

    public Arc getEdge(int src, int dest) {
        return matrix[src][dest]; // assuming not null
    }

    public Iterable<Arc> edges(int src) {
        return edges(nodes.get(src));
    }

    public Iterable<Arc> edges(Node node) {
        return null;
    }

}
