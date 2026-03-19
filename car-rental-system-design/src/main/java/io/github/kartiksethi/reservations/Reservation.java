package io.github.kartiksethi.reservations;

import io.github.kartiksethi.enums.ReservationStatus;
import io.github.kartiksethi.enums.ReservationType;

import java.util.Date;

public class Reservation {
    private final int id;
    private final int storeId;
    private final int vehicleId;
    private final int userId;
    private final Date bookedFrom;
    private final Date bookedTo;
    private final ReservationType reservationType;
    private ReservationStatus reservationStatus;

    public Reservation(int id, int storeId, int vehicleId, int userId, Date bookedFrom, Date bookedTo, ReservationType reservationType, ReservationStatus reservationStatus) {
        this.id = id;
        this.storeId = storeId;
        this.vehicleId = vehicleId;
        this.userId = userId;
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.reservationType = reservationType;
        this.reservationStatus = reservationStatus;
    }

    public int getId() {
        return id;
    }

    public int getStoreId() {
        return storeId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getUserId() {
        return userId;
    }

    public Date getBookedFrom() {
        return bookedFrom;
    }

    public Date getBookedTo() {
        return bookedTo;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus){
        this.reservationStatus = reservationStatus;
    }
}
