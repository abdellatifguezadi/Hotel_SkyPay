package org.example.service.Impl;

import org.example.entity.Booking;
import org.example.entity.Room;
import org.example.entity.RoomType;
import org.example.entity.User;
import org.example.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

public class ServiceImpl implements Service {

    ArrayList<Room> rooms;
    ArrayList<User> users;
    ArrayList<Booking> bookings;

    public ServiceImpl() {
        rooms = new ArrayList<>();
        users = new ArrayList<>();
        bookings = new ArrayList<>();
    }
    @Override
    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        Optional<Room> existingRoom = findRoomByNumber(roomNumber);
        try {
            if (existingRoom.isPresent()) {
                Room room = existingRoom.get();
                room.setRoomType(roomType);
                room.setPricePerNight(roomPricePerNight);
            } else {
                rooms.add(new Room(roomPricePerNight, roomNumber, roomType));
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        try {
            if (checkIn.after(checkOut)) {
                throw new IllegalArgumentException("Check-in date must be before check-out date");
            }
            User user = findUserById(userId).orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
            Room room = findRoomByNumber(roomNumber).orElseThrow(() -> new IllegalArgumentException("Room not found: " + roomNumber));

            if (isRoomBooked(roomNumber, checkIn, checkOut)) {
                throw new IllegalArgumentException("Room is not available for the specified period");
            }

            int nights = (int) ((checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24));
            int totalCost = nights * room.getPricePerNight();

            if (user.getBalance() < totalCost) {
                throw new IllegalArgumentException("Insufficient balance for user: " + userId);
            }
            user.setBalance(user.getBalance() - totalCost);
            bookings.add(new Booking(checkIn, checkOut, roomNumber, room.getPricePerNight(),
                    room.getRoomType(), totalCost, user.getBalance(), userId));
            System.out.println("Booking successful for user " + userId + " in room " + roomNumber);
        }catch (Exception e){
            System.out.println("Booking failed: " + e.getMessage());
        }

    }

    @Override
    public void printAll() {
        for (Booking booking : bookings) {
            System.out.println("Booking Details:");
            System.out.println("User ID: " + booking.getUserId());
            System.out.println("Room Number: " + booking.getRoomNumber());
            System.out.println("Room Type at Booking: " + booking.getRoomTypeAtBooking());
            System.out.println("Room Price at Booking: " + booking.getRoomPriceAtBooking());
            System.out.println("Check-In Date: " + booking.getCheckIn());
            System.out.println("Check-Out Date: " + booking.getCheckOut());
            System.out.println("Total Cost: " + booking.getTotalCost());
            System.out.println("User Balance at Booking: " + booking.getUserBalanceAtBooking());
            System.out.println("---------------------------");
        }
        for (Room room : rooms) {
            System.out.println("Room Details:");
            System.out.println("Room Number: " + room.getRoomNumber());
            System.out.println("Room Type: " + room.getRoomType());
            System.out.println("Price Per Night: " + room.getPricePerNight());
            System.out.println("---------------------------");
        }
    }

    @Override
    public void setUser(int userId, int balance) {
        Optional<User> existingUser = findUserById(userId);
        try {
            if (existingUser.isPresent()) {
                User user = existingUser.get();
                user.setBalance(balance);
            } else {
                users.add(new User(userId, balance));
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printAllUsers() {
        for(User user : users){
            System.out.println("user Details:");
            System.out.println("User ID: " + user.getUserId() + ", Balance: " + user.getBalance());
        }
    }


    private Optional<Room> findRoomByNumber(int roomNumber) {
        return rooms.stream()
                .filter(room -> room.getRoomNumber() == roomNumber)
                .findFirst();
    }

    private Optional<User> findUserById(int userId) {
        return users.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst();
    }

    private boolean isRoomBooked(int roomNumber, Date checkIn, Date checkOut) {
        return bookings.stream()
                .anyMatch(booking -> booking.getRoomNumber() == roomNumber &&
                        !(checkOut.before(booking.getCheckIn()) || checkIn.after(booking.getCheckOut())));
    }
}
