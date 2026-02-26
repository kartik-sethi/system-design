package io.github.kartiksethi.atm;

import io.github.kartiksethi.atmStates.ATMState;
import io.github.kartiksethi.atmStates.IdleATMState;
import io.github.kartiksethi.cashDispenser.CashDispenser;
import io.github.kartiksethi.cashDispenser.CashDispenserFactory;

public class ATMImpl implements ATM {

    private ATMState currentState;
    private final CashDispenser dispenser;
    private int availableCash;

    public ATMImpl(int initialCash) {
        this.dispenser = CashDispenserFactory.getCashDispenser();
        this.availableCash = initialCash;
        this.currentState = IdleATMState.INSTANCE;
    }


    @Override
    public void setState(ATMState state) {
        this.currentState = state;
    }

    @Override
    public ATMState getState() {
        return currentState;
    }

    @Override
    public int getAvailableCash() {
        return availableCash;
    }

    @Override
    public void deductCash(int amount) {
        availableCash -= amount;
    }

    @Override
    public CashDispenser getCashDispenser() {
        return dispenser;
    }

    @Override
    public void insertCard() {
        currentState.insertCard(this);
    }

    @Override
    public void enterPin(String pin) {
        currentState.enterPin(pin, this);
    }

    @Override
    public void requestCash(int amount) {
        currentState.requestCash(amount, this);
    }

    @Override
    public void cancelTransaction() {
        currentState.cancelTransaction(this);
    }
}