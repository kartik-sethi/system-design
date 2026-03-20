package io.github.kartiksethi;

public class Tree {
    String color;
    int size;

    public Tree(String color, int size){
        this.color = color;
        this.size = size;
    }

    void display(int x, int y){
        System.out.println("Tree with color " + color + " and size " + size + " is displayed at " + x + ", " + y);
    }
}
