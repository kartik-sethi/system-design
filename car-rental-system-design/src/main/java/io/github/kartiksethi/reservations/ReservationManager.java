package io.github.kartiksethi.reservations;

import io.github.kartiksethi.enums.ReservationType;
import io.github.kartiksethi.enums.ReservationStatus;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class ReservationManager {

    private final ConcurrentHashMap<Integer, Reservation> reservations = new ConcurrentHashMap<>();

    public Reservation addReservation(int storeId, int vehicleId, int userId, Date bookedFrom, Date bookedTo, ReservationType reservationType){
        int id = (int) (Math.random() * 10000);
        Reservation reservation = new Reservation(id, storeId, vehicleId, userId, bookedFrom, bookedTo, reservationType, ReservationStatus.CONFIRMED);
        reservations.put(id, reservation);
        return reservation;
    }

    public Reservation cancelReservation(int reservationId){
        Reservation reservation = reservations.get(reservationId);
        reservation.setReservationStatus(ReservationStatus.CANCELLED);
        return reservation;
    }

    public Reservation findById(int reservationId){
        return reservations.get(reservationId);
    }

    public Reservation findByStoreIdAndVehicleIdAndIn(int storeId, int vehicleId, Date from, Date to){
        return reservations.values().stream().filter(reservation -> {
            return reservation.getStoreId()==storeId && reservation.getVehicleId()==vehicleId && reservation.getBookedFrom().before(to) && reservation.getBookedTo().after(from);
        }).findFirst().orElse(null);
    }
}