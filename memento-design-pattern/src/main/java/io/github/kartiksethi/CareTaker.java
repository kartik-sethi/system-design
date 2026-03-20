package io.github.kartiksethi;

import java.util.Stack;

public class CareTaker {

    Stack<Memento> mementoStack = new Stack<>();

    public void addMemento(Memento memento){
        mementoStack.push(memento);
    }

    public Memento undo(){
        if(!mementoStack.isEmpty()){
            return mementoStack.pop();
        }
        return null;
    }
}
