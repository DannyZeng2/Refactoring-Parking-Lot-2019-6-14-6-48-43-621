package com.thoughtworks.tdd;

import java.util.List;
import java.util.Map;

public class ParkingBoy {

    public Ticket parkCar(Car car,ParkingLot parkingLot){
        Ticket ticket = new Ticket(car);
        parkingLot.addCar(car,ticket);
        return ticket;
    }

    public Ticket parkCar(Car car, List<ParkingLot> parkingLots){
        Ticket ticket = new Ticket(car);
        parkingLots.get(0).addCar(car,ticket);
        return ticket;
    }

    public Car fetchCar(Ticket ticket,ParkingLot parkingLot) {
        Map<Car, Ticket> cars = parkingLot.getCars();
        if(ticket == null){
            parkingLot.setMessage("Please provide your parking ticket.");
            return null;
        }

        for (Car car : cars.keySet()) {
            if(ticket==cars.get(car)){
                parkingLot.removeCar(car,ticket);
                return car;
            }
        }
        parkingLot.setMessage("Unrecognized parking ticket.");
        return null;
    }
}

