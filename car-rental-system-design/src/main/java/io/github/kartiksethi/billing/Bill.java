package io.github.kartiksethi.billing;

import io.github.kartiksethi.enums.BillStatus;

public class Bill {
    private final int id;
    private final int reservationId;
    private final double amount;
    private BillStatus billStatus;

    public Bill(int id, int reservationId, double amount) {
        this.id = id;
        this.reservationId = reservationId;
        this.amount = amount;
        this.billStatus = BillStatus.UNPAID;
    }

    public int getId() {
        return id;
    }

    public int getReservationId() {
        return reservationId;
    }

    public double getAmount() {
        return amount;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus){
        this.billStatus = billStatus;
    }

}