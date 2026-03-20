package io.github.kartiksethi;

import io.github.kartiksethi.atm.ATM;
import io.github.kartiksethi.atm.ATMImpl;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATMImpl(50000);

        atm.insertCard();
        atm.enterPin("1234");
        atm.requestCash(3700);
    }
}