package com.thoughtworks.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MoreCleverParkingboy extends ParkingBoy{

    public Ticket parkCar(Car car, List<ParkingLot> parkingLots) {
        Ticket ticket = new Ticket(car);
        List<ParkingLot> parkingLot = parkingLots.stream().sorted(Comparator.comparing(lot -> 1-(float)lot.getCars().size()/lot.getMaxCapacity())).collect(Collectors.toList());
        parkingLot.get(parkingLots.size()-1).addCar(car,ticket);
        return  ticket;
    }
}
