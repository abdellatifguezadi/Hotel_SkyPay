package org.example.entity;

import java.time.LocalDate;

public class Booking {
    private int userId;
    private int roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int totalCost;
    private int userBalanceAtBooking;
    private RoomType roomTypeAtBooking;
    private int roomPriceAtBooking;

    public Booking(LocalDate checkIn, LocalDate checkOut, int roomNumber, int roomPriceAtBooking, RoomType roomTypeAtBooking, int totalCost, int userBalanceAtBooking, int userId) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomNumber = roomNumber;
        this.roomPriceAtBooking = roomPriceAtBooking;
        this.roomTypeAtBooking = roomTypeAtBooking;
        this.totalCost = totalCost;
        this.userBalanceAtBooking = userBalanceAtBooking;
        this.userId = userId;
    }


    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomPriceAtBooking() {
        return roomPriceAtBooking;
    }

    public void setRoomPriceAtBooking(int roomPriceAtBooking) {
        this.roomPriceAtBooking = roomPriceAtBooking;
    }

    public RoomType getRoomTypeAtBooking() {
        return roomTypeAtBooking;
    }

    public void setRoomTypeAtBooking(RoomType roomTypeAtBooking) {
        this.roomTypeAtBooking = roomTypeAtBooking;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getUserBalanceAtBooking() {
        return userBalanceAtBooking;
    }

    public void setUserBalanceAtBooking(int userBalanceAtBooking) {
        this.userBalanceAtBooking = userBalanceAtBooking;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
