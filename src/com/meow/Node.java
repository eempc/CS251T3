package com.meow;

public class Node {
    private int n; // the value
    private String name;
    private boolean visited;

    // constructor and getters/setters, toggler for visited?


    public Node(int n, String name) {
        this.n = n;
        this.name = name;
        this.visited = false;
    }

    public Node(int n, String name, boolean visited) {
        this.n = n;
        this.name = name;
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void visit() {
        setVisited(true);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
