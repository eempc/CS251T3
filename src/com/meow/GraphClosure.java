package com.meow;

public class GraphClosure {
    private static int noOfNodes = 4;

    // boolean, can node x reach node y, this is a highly optimised version that takes a
    // graph matrix input where 1 is the presence of an edge from the left node to the top node
    public static void transitiveClosure(int[][] graph) {
        int[][] reach = new int[graph.length][graph.length]; // reachability matrix, true or false
        int i, j, k;

        // 1 Look for direct edges
        for (i = 0; i < graph.length; i++) {
            for (j = 0; j < graph.length; j++) {
                reach[i][j] = graph[i][j]; // If there is a direct edge, just fill that in
            }
        }

        for (k = 0; k < graph.length; k++) {
            for (i = 0; i < graph.length; i++) {
                for (j = 0; j < graph.length; j++) {
                    reach[i][j] = (reach[i][j] == 1 || ((reach[i][k] == 1) && (reach[k][j] == 1))) ? 1 : 0;
                }
            }
        }

        printSolution(reach);
    }

    public static void printSolution(int[][] reach) {
        // Print out everything in the matrix
        for (int i = 0; i < reach.length; i++) {
            for (int j = 0; j < reach.length; j++) {
                System.out.print(reach[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Plug this graph into the above method

    int[][] graph = new int[][] {
            {1, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1},
            {1, 1, 0, 0}
    };

}
