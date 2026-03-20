package io.github.kartiksethi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator(10, 5);
        CareTaker careTaker = new CareTaker();
        careTaker.addMemento(originator.save());
        System.out.println("Current State: " + originator);


        originator.setX(20);
        careTaker.addMemento(originator.save());
        System.out.println("Current State: " + originator);


        originator.sety(15);
        careTaker.addMemento(originator.save());
        System.out.println("Current State: " + originator);

        originator.restore(careTaker.undo());
        System.out.println("Restored to first state: " + originator);

        originator.restore(careTaker.undo());
        System.out.println("Restored to second state: " + originator);

        originator.restore(careTaker.undo());
        System.out.println("Restored to second state: " + originator);    }
}