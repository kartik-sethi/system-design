package io.github.kartiksethi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Tree blueTree = new Tree("blue", 10);
        Tree redTree = new Tree("red", 5);

        for(int i = 0; i < 10; i++){
            blueTree.display(i, i);
        }
        for(int i =  0; i < 10; i++){
            redTree.display(i, i);
        }
    }
}