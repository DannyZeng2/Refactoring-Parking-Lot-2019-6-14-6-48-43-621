package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy{

    private List<ParkingBoy> managementList = new ArrayList<>();

    public void addParkingBoy(ParkingBoy parkingBoys) {
        managementList.add(parkingBoys);
    }


    public List<ParkingBoy> getManagementList() {
        return managementList;
    }

    public ParkingBoy specifyParkingBoy(int id){
        return managementList.get(id-1);

    }

    @Override
    public Ticket parkCar(Car car, List<ParkingLot> parkingLots) {
        return null;
    }
}
