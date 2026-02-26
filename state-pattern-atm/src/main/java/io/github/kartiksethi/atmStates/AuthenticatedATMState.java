package io.github.kartiksethi.atmStates;

import io.github.kartiksethi.atm.ATM;
import io.github.kartiksethi.ATMStateType;

public class AuthenticatedATMState extends AbstractATMState {

    public static final AuthenticatedATMState INSTANCE = new AuthenticatedATMState();

    private AuthenticatedATMState() {}

    @Override
    public void requestCash(int amount, ATM atm) {

        if (!isAmountValid(amount)) {
            System.out.println("Invalid withdrawal amount");
            cancelTransaction(atm);
            return;
        }

        if (amount > atm.getAvailableCash()) {
            System.out.println("Insufficient ATM balance");
            cancelTransaction(atm);
            return;
        }

        System.out.println("Withdrawal request accepted");
        ATMState nextAtmState = DispensingATMState.INSTANCE;
        atm.setState(nextAtmState);
        nextAtmState.dispenseCash(amount, atm);
    }

    @Override
    public ATMStateType getStateType(){
        return ATMStateType.AUTHENTICATED;
    }

    private boolean isAmountValid(int amount){
        return amount > 0 && amount <= 10000;
    }
}