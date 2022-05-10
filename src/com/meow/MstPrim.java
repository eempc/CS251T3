package com.meow;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MstPrim {
    private static final int size = 5;

    public int minKey(int[] key, Boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < size; v++) {
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public void printMst(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < size; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    public void primMst(int[][] graph) {
        int parent[] = new int[size];
        int[] key = new int[size];
        Boolean[] mstSet = new Boolean[size];

        for (int i = 0; i < size; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < size -1; count++) {
            int u = minKey(key, mstSet);

            for (int v = 0; v < size; v++) {
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMst(parent, graph);
    }

    public static void main(String[] args) {
        MstPrim t = new MstPrim();
        int[][] graph = new int[][] {
                {0,2,0,6,0},
                {0,3,0,0,7},
                {2,0,3,8,5},
                {6,8,0,0,9},
                {0,5,7,9,0}
        };
        t.primMst(graph);
    }

    public static void bookPseudo(AdjacencyListStructure graph, Node src) {
        // Output is MST
        AdjacencyListStructure output = new AdjacencyListStructure(false);
        // Distance container
        HashMap<Node, Integer> distances = new HashMap<>();
        //
        PriorityQueue<Map.Entry<Integer, Node>> pq = new PriorityQueue<>();

        distances.put(src, 0);

        for (Node n : graph.getNodes()) {
            if (n != src) {
                distances.put(n, Integer.MAX_VALUE);
            }
        }





    }
}
