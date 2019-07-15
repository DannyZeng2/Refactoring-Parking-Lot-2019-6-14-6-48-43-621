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


//    public Ticket parkCarStupid(Car car,ParkingLot parkingLot1,ParkingLot parkingLot2){
//        Ticket ticket = new Ticket(car);
//        if(parkingLot1.getCars().size()==parkingLot1.getMaxCapacity()){
//            parkingLot2.addCar(car,ticket);
//        }else {
//            parkingLot1.addCar(car,ticket);
//        }
//
//        return ticket;
//    }
//
//    public Ticket parkCarClever(Car car,ParkingLot parkingLot1,ParkingLot parkingLot2){
//        Ticket ticket = new Ticket(car);
//        if(parkingLot1.getCars().size()<parkingLot2.getCars().size()&&parkingLot1.getCars().size()<parkingLot1.getMaxCapacity()){
//            parkingLot1.addCar(car,ticket);
//        }else{
//            parkingLot2.addCar(car,ticket);
//        }
//        return ticket;
//    }
//
//    public Ticket parkCarInlargerRate(Car car,ParkingLot parkingLot1,ParkingLot parkingLot2){
//        Ticket ticket = new Ticket(car);
//
//        if(parkingLot1.getCars().size()==0&&parkingLot2.getCars().size()==0){
//            if(parkingLot1.getMaxCapacity()>parkingLot2.getMaxCapacity()){
//                parkingLot1.addCar(car,ticket);
//            }else {
//                parkingLot2.addCar(car,ticket);
//            }
//        }else {
//
//            float rate1 = 1-(float)parkingLot1.getCars().size()/parkingLot1.getMaxCapacity();
//            float rate2 = 1-(float)parkingLot2.getCars().size()/parkingLot2.getMaxCapacity();
//
//            if(rate1>rate2 && parkingLot1.getCars().size()<parkingLot1.getMaxCapacity()){
//                parkingLot1.addCar(car,ticket);
//            }else{
//                parkingLot2.addCar(car,ticket);
//            }
//        }
//
//        return ticket;
//    }

    public Car returnCar(Ticket ticket,ParkingLot parkingLot) {
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

