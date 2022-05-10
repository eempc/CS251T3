package com.meow;

import java.util.Arrays;
/*
let dist be a |V| × |V| array of minimum distances initialized to ∞ (infinity)
for each edge (u, v) do
    dist[u][v] ← w(u, v)  // The weight of the edge (u, v)
for each vertex v do
    dist[v][v] ← 0
for k from 1 to |V|
    for i from 1 to |V|
        for j from 1 to |V|
            if dist[i][j] > dist[i][k] + dist[k][j]
                dist[i][j] ← dist[i][k] + dist[k][j]
            end if
 */

// https://www.tutorialspoint.com/Floyd-Warshall-Algorithm
public class Floyd {

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {0, 0, 2, 0},
                {4, 0, 3, 0},
                {0, 0, 0, 2},
                {0, 1, 0, 0},
        };

        int[][] result = FloydWarshall(graph);

        for (int[] subArray : result) {
            System.out.println("\n");
            for (int x : subArray) {
                System.out.print(x + " ");
            }
        }
    }

    // Input is a graph of weight integers of the edges connecting those two nodes
    // this is a directed graph
    public static int[][] FloydWarshall(int[][] graph) {
        // Fill a 2D array of distances with max value
        int[][] distancesOutput = new int[4][4]; // Ideally this would be an array list to handle any sizes but who wants to deal with that
//        for (int[] subArray : distancesOutput) {
//            Arrays.fill(subArray, 1000);
//        }

        // For each edge, assign the weight of the adjacent edge nodes since those are the easiest ones to do // Also fill in the self-nodes with distance of 0
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i == j) {
                    distancesOutput[i][j] = 0; // distance is 0 from a node to itself
                } else if (graph[i][j] == 0) {
                    distancesOutput[i][j] = 1000; // Don't do Int Max, you might be in danger of rolling over
                } else {
                    distancesOutput[i][j] = graph[i][j]; // Otherwise start off with the adjacent edges
                }
            }
        }

        // Loop 3 times
        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (i != j) {
                        if (distancesOutput[i][j] > distancesOutput[i][k] + distancesOutput[k][j]) {
                            distancesOutput[i][j] = distancesOutput[i][k] + distancesOutput[k][j];
                        }
                    }
                }
            }
        }

        return distancesOutput;
    }
}
