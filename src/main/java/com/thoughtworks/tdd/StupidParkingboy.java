package com.thoughtworks.tdd;


import java.util.List;
import java.util.stream.Collectors;

public class StupidParkingboy extends ParkingBoy {
    @Override
    public Ticket parkCar(Car car, List<ParkingLot> parkingLotList) {
        Ticket ticket = new Ticket(car);

        for(int i=0;i<parkingLotList.size()-1;i++){
            if(parkingLotList.get(i).getCars().size()== parkingLotList.get(i).getMaxCapacity()){
                parkingLotList.get(i+1).addCar(car,ticket);
            }else {
                parkingLotList.get(i).addCar(car,ticket);
            }
        }

        return ticket;
    }
}
