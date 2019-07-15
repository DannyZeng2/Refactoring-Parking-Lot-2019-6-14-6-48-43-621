package com.thoughtworks.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CleverParkingboy extends ParkingBoy{

    @Override
    public Ticket parkCar(Car car, List<ParkingLot> parkingLots) {
        Ticket ticket = new Ticket(car);
        List<ParkingLot> pl = parkingLots.stream().sorted(Comparator.comparing(lot -> lot.getMaxCapacity() - lot.getCars().size())).collect(Collectors.toList());
        pl.get(parkingLots.size()-1).addCar(car,ticket);
        return  ticket;
    }

}
