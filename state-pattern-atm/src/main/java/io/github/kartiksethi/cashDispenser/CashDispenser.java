package io.github.kartiksethi.cashDispenser;

public abstract class CashDispenser {

    protected final CashDispenser nextDispenser;

    public CashDispenser(CashDispenser nextDispenser){
        this.nextDispenser = nextDispenser;
    }

    public void dispense(int amount){
        if(nextDispenser != null){
            nextDispenser.dispense(amount);
        } else if(amount > 0){
            System.out.println("Cannot dispense remaining amount: " + amount);
        }
    }
}
