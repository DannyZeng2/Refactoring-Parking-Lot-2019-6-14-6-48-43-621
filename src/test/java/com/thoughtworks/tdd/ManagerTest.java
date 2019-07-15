package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    @Test
    public void add_parking_boys_to_management_list() {  //预估：8min 实际：10min
        //Given
        Manager manager = new Manager();
        ParkingLot parkingLot = new ParkingLot(manager,5);

        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();

        //When
        manager.addParkingBoy(parkingBoy1);
        manager.addParkingBoy(parkingBoy2);

        //Then
        Assertions.assertEquals(2, manager.getManagementList().size());
       ;
    }

    @Test
    public void should_specify_a_parking_boy_park_the_car () {  //预估：8min 实际：10min
        //Given
        Manager manager = new Manager();
        ParkingLot parkingLot = new ParkingLot(manager,5);

        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();

        manager.addParkingBoy(parkingBoy1);
        manager.addParkingBoy(parkingBoy2);

        //When
        ParkingBoy parkingBoy = manager.specifyParkingBoy(1);
        Ticket ticket = parkingBoy.parkCar(new Car(),parkingLot);
        //Then
        Assertions.assertEquals(parkingBoy1, parkingBoy);
        Assertions.assertNotNull(ticket);
        ;
    }

    @Test
    public void should_park_or_fetch_the_car_from_manager_own_parking_lots() {  //预估：8min 实际：10min
        //Given
        Car car = new Car();
        Manager manager = new Manager();
        ParkingLot parkingLot1 = new ParkingLot(manager,5);

        //When
        Ticket ticket1 = manager.parkCar(car, parkingLot1);
        Car returnCar1 = manager.fetchCar(ticket1, parkingLot1); //ticket1 has been used!!!
        //Then
        Assertions.assertEquals(car, returnCar1);
    }

    @Test
    public void should_not_park_or_fetch_the_car_not_from_own_parking_lots() {  //预估：8min 实际：10min
        //Given
        Car car = new Car();
        Manager manager1 = new Manager();
        Manager manager2 = new Manager();
        ParkingLot parkingLot1 = new ParkingLot(manager1,5);
        ParkingLot parkingLot2 = new ParkingLot(manager2,8);

        //When
        Ticket ticket = manager1.parkCar(car, parkingLot1);
        Car returnCar = manager1.fetchCar(ticket, parkingLot2);
        //Then
        Assertions.assertEquals(null, returnCar);
    }


}
