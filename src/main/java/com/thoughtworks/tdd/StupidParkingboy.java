package com.thoughtworks.tdd;


import java.util.List;
import java.util.stream.Collectors;

public class StupidParkingboy extends ParkingBoy {
    @Override
    public Ticket parkCar(Car car, List<ParkingLot> parkingLots) {
        Ticket ticket = new Ticket(car);

        for(int i=0;i<parkingLots.size()-1;i++){
            if(parkingLots.get(i).getCars().size()== parkingLots.get(i).getMaxCapacity()){
                parkingLots.get(i+1).addCar(car,ticket);
            }else {
                parkingLots.get(i).addCar(car,ticket);
            }
        }
        return ticket;
    }
}
