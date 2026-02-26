package io.github.kartiksethi.atm;

import io.github.kartiksethi.atmStates.ATMState;
import io.github.kartiksethi.cashDispenser.CashDispenser;

public interface ATM {

    void setState(ATMState state);

    ATMState getState();

    int getAvailableCash();

    CashDispenser getCashDispenser();

    void insertCard();

    void enterPin(String pin);

    void requestCash(int amount);

    void cancelTransaction();

    void deductCash(int amount);
}