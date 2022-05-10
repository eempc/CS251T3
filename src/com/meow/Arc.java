package com.meow;

// Just another name for Edge for use with the Edge list structure, no weighting at the moment
public class Arc {
    private Node source, destination;
    private int weight;
    public Arc() {
    }

    public Arc(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
        this.weight = 1;
    }

    public Arc(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }
}
