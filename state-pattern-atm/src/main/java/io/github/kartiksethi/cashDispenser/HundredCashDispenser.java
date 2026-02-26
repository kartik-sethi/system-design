package io.github.kartiksethi.cashDispenser;

public class HundredCashDispenser extends CashDispenser {

    public HundredCashDispenser(CashDispenser nextDispenser){
        super(nextDispenser);
    }

    @Override
    public void dispense(int amount){
        int take = amount / 100;
        int rem = amount % 100;

        if(take > 0){
            System.out.println(take + " x 100 notes dispensed");
        }

        super.dispense(rem);
    }
}