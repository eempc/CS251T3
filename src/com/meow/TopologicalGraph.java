package com.meow;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalGraph {
    private int noOfNodes;
    private LinkedList<Integer>[] adjacency; // an array of linked lists, serves as the edge map, the [] appears to be an array of edges

    public TopologicalGraph(int noOfNodes) {
        this.noOfNodes = noOfNodes;
        adjacency = new LinkedList[noOfNodes];

        for (int i = 0; i < noOfNodes; i++) {
            adjacency[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjacency[v].add(w);
    }

    public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true; // set that node to true

        for (Integer i : adjacency[v]) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(v); // add to the stack
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[noOfNodes];

        // Reset visited to false
        for (int i = 0; i < noOfNodes; i++) {
            visited[i] = false;
        }

        // Traverse the nodes
        for (int i = 0; i < noOfNodes; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.empty()) {
            System.out.println(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TopologicalGraph graph = new TopologicalGraph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.topologicalSort();
    }
}
