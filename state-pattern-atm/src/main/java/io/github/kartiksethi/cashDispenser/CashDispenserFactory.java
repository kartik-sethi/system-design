package io.github.kartiksethi.cashDispenser;

public class CashDispenserFactory {

    public static CashDispenser getCashDispenser(){
        return new TwoThousandCashDispenser(
                        new FiveHundredCashDispenser(
                                new HundredCashDispenser(null)
                        )
                );
    }
}
