package org.example.entity;

public class Room {

    private int roomNumber;
    private RoomType roomType;
    private int pricePerNight;

    public Room(int pricePerNight, int roomNumber, RoomType roomType) {
        this.pricePerNight = pricePerNight;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
