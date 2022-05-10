package com.meow;

import java.util.*;

// Map of nodes with a hashmap where the key is the opposite and the edge is the value
public class AdjacencyMapStructure {
    private HashMap<Node, HashMap<Node, Arc>> adjacencyMapMap = new HashMap<>();
    private List<Arc> edges = new LinkedList<>();
    boolean isDirected;

    public AdjacencyMapStructure(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public void addEdge(Node source, Node destination) {
        Arc tempArc = new Arc(source, destination);
        HashMap<Node, Arc> tempVal = new HashMap<>();
        tempVal.put(destination, tempArc);

        if (!adjacencyMapMap.containsKey(source)) {
            adjacencyMapMap.put(source, tempVal);
        } else {
            adjacencyMapMap.replace(source, tempVal);
        }

        edges.add(tempArc);

        // Then repeat with vice versa if undirected graph
    }

    // This is not really necessary, this is just to help understand the neighbours are a KeySet
    public Set<Node> getNeighbourNodesHelper(Node src) {
        return adjacencyMapMap.get(src).keySet();
    }

    public HashMap<Node, Arc> getNeighboursAndEdges(Node src) {
        return adjacencyMapMap.get(src);
    }

    public Iterable<Arc> outgoingEdges(Node src) {
        HashMap<Node, Arc> vals = adjacencyMapMap.get(src); // for clarity
        Collection<Arc> temp = vals.values(); // Technically it is a collection
        Collection<Node> temp2 = vals.keySet(); // ALso Set<> really
        return vals.values(); // but could be made one line, a lot of thing can be iterated
    }

    public Iterable<Arc> outgoingEdges2(Node src) {
        ArrayList<Arc> temp = new ArrayList<>();
        HashMap<Node, Arc> vals = adjacencyMapMap.get(src);
        for (Arc a : vals.values()) {
            // A loop is good if you want to do any checks on the edge before adding it to the return value
            temp.add(a);
        }
        return temp;
    }

    public List<Arc> getIncomingEdges(Node src) {
        // this is a nasty one? Do I have to iterate through all the entries' values?
        return null;
    }

    public Iterable<Node> getNodes() {
        return adjacencyMapMap.keySet();
    }

    public HashMap<Node, HashMap<Node, Arc>> getAdjacencyMapMap() {
        return adjacencyMapMap;
    }

    public void dfs(Node target) {
        // 1. set visited and perform action
        target.visit();
        System.out.println(target.getName());

        // 2. Get neighbours, which is a set
        Set<Node> neighbours = adjacencyMapMap.get(target).keySet();
        if (neighbours.size() == 0) {
            return;
        }

        // 3. Travers and recur if unvisited
        for (Node n : neighbours) {
            if (!n.isVisited()) {
                dfs(n); // recur
            }
        }
    }
}
