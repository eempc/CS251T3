package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prim {
    private static class Edge {
        private int weight;
        private boolean isIncluded = false;

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public boolean isIncluded() {
            return isIncluded;
        }

        public void setIncluded(boolean included) {
            isIncluded = included;
        }
    }

    private static class Vertex {
        private String label = null;
        private Map<Vertex, Edge> edges = new HashMap<>();
        private boolean isVisited = false;

        public Vertex() {
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Map<Vertex, Edge> getEdges() {
            return edges;
        }

        public void setEdges(Map<Vertex, Edge> edges) {
            this.edges = edges;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }
    }

    private static List<Vertex> graph = new ArrayList<>();

    // If there are any unvisited nodes, this return true
    private static boolean isDisconnected() {
        for (Vertex vertex : graph) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        if (graph.size() > 0) {
            graph.get(0).setVisited(true);
        }

        while (isDisconnected()) {

        }
    }


}
