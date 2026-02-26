package io.github.kartiksethi.atmStates;

import io.github.kartiksethi.atm.ATM;

public abstract class AbstractATMState implements ATMState {

    @Override
    public void insertCard(ATM atm){
        System.out.println("Operation not allowed in current state");
    }

    @Override
    public void enterPin(String pin, ATM atm){
        System.out.println("Operation not allowed in current state");
    }

    @Override
    public void requestCash(int amount, ATM atm){
        System.out.println("Operation not allowed in current state");
    }

    @Override
    public void dispenseCash(int amount, ATM atm){
        System.out.println("Operation not allowed in current state");
    }

    @Override
    public void cancelTransaction(ATM atm){
        System.out.println("Transaction cancelled");
        ejectCard(atm);
    }

    protected void ejectCard(ATM atm){
        System.out.println("Card ejected");
        atm.setState(IdleATMState.INSTANCE);
    }

}
