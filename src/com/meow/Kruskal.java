package com.meow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {
    public static class Graph {
        private int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        public Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }

        // FOr Kruskal's MST, you use a PQ
        public void kruskalMst() {
            // PQ only needs the edges as long as the edge contains source, dest and weight, they will be dequeued according to minimum weight later
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(Edge::getWeight));

            // Add all edges to the PQ, doesn't matter if you use the sorted or unsorted PQ
            for (int i = 0; i < allEdges.size(); i++) {
                pq.add(allEdges.get(i));
            }

            int[] parent = new int[vertices];
            makeSet(parent); // an ascending array, but why?

            List<Edge> mst = new ArrayList<>(); // output

            // Start to process the PQ
            int index = 0;
            while (index < vertices - 1) { // We only need n number of edges to equal nodes - 1
                Edge edge = pq.remove();
                int xSet = find(parent, edge.getSource()); // finding leader index of  cluster of source
                int ySet = find(parent, edge.getDestination()); // find leader index of cluster of destination

                // If they are not the same cluster (i.e. that would mean they are both already in the cloud), it means it is a new Edge to be included
                // add that edge to the MST
                if (xSet != ySet) {
                    mst.add(edge);
                    index++; // We have added a new edge
                    union(parent, xSet, ySet); // Join the two clusters up
                }
            }
        }



        private void union(int[] parent, int xSet, int ySet) {
            int xSetParent = find(parent, xSet);
            int ySetParent = find(parent, ySet);
            parent[ySetParent] = xSetParent; // If they are the same cluster, this will do nothing?
        }

        private void makeSet(int[] parent) {
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        // Odd method to find the leader's index by recurring through the array
        private int find(int[] parent, int source) {
            if (parent[source] != source) {
                return find(parent, parent[source]);
            }
            return source;
        }

        private void printGraph(List<Edge> mst) {
            for (int i = 0; i < mst.size(); i++) {
                Edge edge = mst.get(i);
                System.out.println("Edge-" + i + " source: " + edge.getSource() + " dest " + edge.getDestination() + " weight" + edge.getWeight());
            }
        }
    }
}
