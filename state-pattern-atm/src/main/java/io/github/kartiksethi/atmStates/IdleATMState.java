package io.github.kartiksethi.atmStates;

import io.github.kartiksethi.atm.ATM;
import io.github.kartiksethi.ATMStateType;

public class IdleATMState extends AbstractATMState {

    public static final IdleATMState INSTANCE = new IdleATMState();

    private IdleATMState() {}

    @Override
    public void insertCard(ATM atm){
        System.out.println("Card Inserted");
        atm.setState(CardInsertedAtmState.INSTANCE);
    }

    @Override
    public ATMStateType getStateType(){
        return ATMStateType.IDLE;
    }
}
