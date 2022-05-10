package com.meow;

public class UnionGraph {
    private int V, E;
    private Edge[] edges;

    public UnionGraph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i) {
            edges[i] = new Edge();
        }
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }

    public int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }

    public boolean isCycle() {
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < E; ++i) {
            int x = find(parent, edges[i].getSource());
            int y = find(parent, edges[i].getDestination());

            // Is cycle?
            if (x == y) {
                return true;
            }

            union(parent, x, y);
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 3, E = 3;
        UnionGraph graph = new UnionGraph(V, E);

        graph.edges[0].setSource(0);
        graph.edges[0].setDestination(1);

        graph.edges[1].setSource(1);
        graph.edges[1].setDestination(2);

        graph.edges[2].setSource(0);
        graph.edges[2].setDestination(2);

        if (graph.isCycle()) {
            System.out.println("graph has cycle");
        } else {
            System.out.println("graph has no cycle");
        }
    }
}
