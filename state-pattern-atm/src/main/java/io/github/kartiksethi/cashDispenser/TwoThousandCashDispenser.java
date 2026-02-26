package io.github.kartiksethi.cashDispenser;

public class TwoThousandCashDispenser extends CashDispenser {

    public TwoThousandCashDispenser(CashDispenser nextDispenser){
        super(nextDispenser);
    }

    @Override
    public void dispense(int amount){
        int take = amount / 2000;
        int rem = amount % 2000;

        if(take > 0){
            System.out.println(take + " x 2000 notes dispensed");
        }

        super.dispense(rem);
    }
}