package com.meow;

import java.util.*;

public class TopoSort {
    public static List<Node> topoSort(AdjacencyMapStructure graph) {
        // 1 Three containers
        List<Node> output = new LinkedList<>();
        Stack<Node> working = new Stack<>();
        Map<Node, Integer> inCount = new HashMap<>();

        // 2 Add all nodes to the inCount along with their count for incomingEdges
        // Find the start nodes, i.e. the ones with 0 incomingEdges
        for (Node current : graph.getAdjacencyMapMap().keySet()) {
            inCount.put(current, graph.getIncomingEdges(current).size()); // this method is not implemented to get the size of the incomingEdges
            if (inCount.get(current) == 0) {
                working.push(current);
            }
        }

        // 3 Start popping the stack in this while loop
        while (!working.isEmpty()) {
            Node u = working.pop(); // Get the pop
            output.add(u); // Add it to the output list, perform action if you want

            // 4 Traverse the neighbours and decrement their inCount
            for (Node neighbour : graph.getNeighbourNodesHelper(u)) { // Can also be a simple .get() with a hashmap inside a hashmap
                inCount.put(neighbour, inCount.get(neighbour) - 1); // decrement
                if (inCount.get(neighbour) == 0) {
                    working.push(neighbour);
                }
            }
        }

        return output;
    }

}
