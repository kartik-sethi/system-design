package io.github.kartiksethi.cashDispenser;

public class FiveHundredCashDispenser extends CashDispenser{
    public FiveHundredCashDispenser(CashDispenser nextDispenser){
        super(nextDispenser);
    }

    @Override
    public void dispense(int amount){
        int take = amount/500;
        int rem = amount%500;
        if(take > 0){
            System.out.println(take + " x 500 notes dispensed");
        }
        super.dispense(rem);
    }
}
