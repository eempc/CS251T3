package com.meow;

import java.util.ArrayList;
import java.util.List;

// Edge list structure, the
public class EdgeListStructureGraph {
    private List<Node> nodeList; // Using simple arrayList for now, can be any list structure really, depends on what runtime you need
    private List<Arc> arcList;

    public EdgeListStructureGraph() {
        this.nodeList = new ArrayList<>();
        this.arcList = new ArrayList<>();
    }

    // add node Runtime is not an issue at the moment
    public void addNode(Node n) {
        if (!nodeList.contains(n))
            nodeList.add(n);
    }

    public Node removeNode(Node n) {
        if (nodeList.contains(n)) {
            nodeList.remove(n);
            return n; // no temp node needed
        }
        return null;
    }

    // Overloaded edge additions with reference to the nodes
    public void addArc(Node src, Node dest) {
        // Can also check that source and destination exist
        Arc newEdge = new Arc(src, dest);
        addEdge(newEdge);
    }

    // Add edge via integers
    public void addEdge(int src, int dest) {
        // Can check that source and destination are within the index boundaries
        Node source = nodeList.get(src);
        Node destination = nodeList.get(dest);
        // Can check that an arc doesn't already exist
        Arc newEdge = new Arc(source, destination);
        addEdge(newEdge);
    }

    // Actual add
    public void addEdge(Arc a) {
        arcList.add(a);
    }

    // Simple remove
    public void removeEdge(Arc arc) {
        arcList.remove(arc);
    }

    // this is ridiculous and why you don't do DFS/BFS with an Edge List structure
    // Doesn't matter what type of list you use, you have to go through it all O(n)
    public List<Node> getNeighbours(Node n) {
        List<Node> temp = new ArrayList<>();
        for (Arc a : arcList) {
            if (a.getSource() == n) {
                temp.add(a.getDestination());
            }
        }
        return temp;
    }

    // DFS wil be very inefficient, start at a target node and then get all the neighbours of that start node,
    // means you have to go through all of the arcList to find the opposite of the target

}
