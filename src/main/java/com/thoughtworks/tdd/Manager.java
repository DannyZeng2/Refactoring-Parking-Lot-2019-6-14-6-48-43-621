package com.thoughtworks.tdd;

import java.util.List;

public class Manager extends ParkingBoy{
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public Ticket parkCar(Car car, List<ParkingLot> parkingLots) {
        return null;
    }
}
