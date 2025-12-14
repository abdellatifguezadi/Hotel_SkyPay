package org.example;

import org.example.entity.RoomType;
import org.example.service.Impl.ServiceImpl;
import org.example.service.Service;

import java.util.Date;
import java.util.Calendar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Service service = new ServiceImpl();

        service.setRoom(1, RoomType.STANDARD, 1000);
        service.setRoom(2, RoomType.JUNIOR, 2000);
        service.setRoom(3, RoomType.SUITE, 3000);

        service.setUser(1, 5000);
        service.setUser(2, 10000);

        Calendar cal = Calendar.getInstance();
        cal.set(2026, 5, 30);
        Date checkIn1 = cal.getTime();
        cal.set(2026, 6, 7);
        Date checkOut1 = cal.getTime();
        cal.set(2026, 6, 7);
        Date checkIn2 = cal.getTime();
        cal.set(2026, 5, 30);
        Date checkOut2 = cal.getTime();
        cal.set(2026, 6, 7);
        Date checkIn3 = cal.getTime();
        cal.set(2026, 6, 8);
        Date checkOut3 = cal.getTime();
        cal.set(2026, 6, 7);
        Date checkIn4 = cal.getTime();
        cal.set(2026, 6, 9);
        Date checkOut4 = cal.getTime();
        cal.set(2026, 6, 7);
        Date checkIn5 = cal.getTime();
        cal.set(2026, 6, 8);
        Date checkOut5 = cal.getTime();

        System.out.println("=== BOOKING ATTEMPTS ===");
        service.bookRoom(1, 2, checkIn1, checkOut1); // Insufficient balance
        service.bookRoom(1, 2, checkIn2, checkOut2); // Check-in  after check-out
        service.bookRoom(1, 1, checkIn3, checkOut3);
        service.bookRoom(2, 1, checkIn4, checkOut4); // not available Room
        service.bookRoom(2, 3, checkIn5, checkOut5);

        service.setRoom(1, RoomType.SUITE, 10000);

        System.out.println("=== FINAL RESULTS ===");
        service.printAll();
        System.out.println();
        service.printAllUsers();
    }
}