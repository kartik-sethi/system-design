package io.github.kartiksethi.atmStates;

import io.github.kartiksethi.atm.ATM;
import io.github.kartiksethi.ATMStateType;
import io.github.kartiksethi.cashDispenser.CashDispenser;

public class DispensingATMState extends AbstractATMState {

    public static final DispensingATMState INSTANCE = new DispensingATMState();

    private DispensingATMState(){}

    @Override
    public void dispenseCash(int amount, ATM atm){

        System.out.println("Dispensing cash...");

        CashDispenser dispenser = atm.getCashDispenser();
        dispenser.dispense(amount);

        atm.deductCash(amount);


        System.out.println("Transaction complete");
        ejectCard(atm);
    }
    @Override
    public ATMStateType getStateType(){
        return ATMStateType.DISPENSING;
    }
}