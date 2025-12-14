package org.example.service;

import org.example.entity.RoomType;

import java.util.Date;

public interface Service {

    void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight);
    void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut);
    void printAll();
    void setUser(int userId, int balance);
    void printAllUsers();
}
