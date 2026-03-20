package io.github.kartiksethi;

public class Memento {
    private final int x;
    private final int y;

    public Memento(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }
}
