package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private Manager manager;

    private Map<Car,Ticket> cars = new HashMap();
    private int maxCapacity = 2;
    private String Message;
    private List<ParkingBoy> parkingBoylist = new ArrayList<>();

    public ParkingLot(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ParkingLot(Manager manager, int maxCapacity) {
        this.manager = manager;
        this.maxCapacity = maxCapacity;
    }

    public List<ParkingBoy> getParkingBoylist() {
        return parkingBoylist;
    }

    public void setParkingBoylist(ParkingBoy parkingBoy) {
        parkingBoylist.add(parkingBoy);
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public void addCar(Car car,Ticket ticket) {

        if(cars.size()<this.maxCapacity) {
            cars.put(car,ticket);
        }else {
            setMessage("Not enough position.");
        }
    }

    public void removeCar(Car car,Ticket ticket) {
        cars.remove(car,ticket);
    }

    public Map<Car, Ticket> getCars() {
        return cars;
    }
}
