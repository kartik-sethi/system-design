package io.github.kartiksethi.atmStates;

import io.github.kartiksethi.atm.ATM;
import io.github.kartiksethi.ATMStateType;

public class CardInsertedAtmState extends AbstractATMState {

    public static final CardInsertedAtmState INSTANCE = new CardInsertedAtmState();

    private CardInsertedAtmState() {}

    @Override
    public void enterPin(String pin, ATM atm){
        System.out.println("Pin entered");

        if(isValidPin(pin)){
            atm.setState(AuthenticatedATMState.INSTANCE);
        } else {
            System.out.println("Invalid pin");
            cancelTransaction(atm);
        }
    }

    private boolean isValidPin(String pin){
        return "1234".equals(pin); // example logic
    }

    @Override
    public ATMStateType getStateType(){
        return ATMStateType.CARD_INSERTED;
    }
}


