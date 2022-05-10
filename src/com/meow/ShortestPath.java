package com.meow;

public class ShortestPath {
    public static final int NODES = 9;

    public void printSolution(int[] dist, int n) {
        System.out.println("Node distance from source");
        for (int i = 0; i < NODES; i++) {
            System.out.println(i + " tt " + dist[i]);
        }
    }
    public int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int n = 0; n < NODES; n++) {
            if (!sptSet[n] && dist[n] <= min) {
                min = dist[n]; // find minimum distance
                minIndex = n;
            }
        }
        return minIndex;
    }

    // Input is a 2d matrix graph with weighted edges denoted by an integer
    public void dijkstra(int[][] graph, int src) {
        int[] dist = new int[NODES]; // List of distance labels for each node
        boolean[] sptSet = new boolean[NODES]; // List of visited?

        for (int i = 0; i < NODES; i++) {
            dist[i] = Integer.MAX_VALUE; // set distance to max for each label
            sptSet[i] = false; // set this to false, i.e. unsettled, not in cloud
        }

        dist[src] = 0; // the distance from src to src is 0, obviously

        for (int count = 0; count < NODES - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < NODES; v++) {
                if (!sptSet[v] // not in cloud
                        && graph[u][v] != 0 // has an edge
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        printSolution(dist, NODES);
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 1, 0},
                {0, 0, 7, 0, 9, 1, 0, 0, 0},
                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                {0, 0, 4, 4, 1, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 1, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 6},
        };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}
