package io.github.kartiksethi.atmStates;

import io.github.kartiksethi.atm.ATM;
import io.github.kartiksethi.ATMStateType;

public interface ATMState {
    void insertCard(ATM atm);

    void enterPin(String pin, ATM atm);

    void requestCash(int amount, ATM atm);

    void dispenseCash(int amount, ATM atm);

    void cancelTransaction(ATM atm);

    ATMStateType getStateType();
}
