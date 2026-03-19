package io.github.kartiksethi.billing;

public class Bill {
    private final int id;
    private final int reservationId;
    private final double amount;

    public Bill(int id, int reservationId, double amount) {
        this.id = id;
        this.reservationId = reservationId;
        this.amount = amount;
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
}