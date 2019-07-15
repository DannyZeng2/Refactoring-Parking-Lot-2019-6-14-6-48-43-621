package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoyTest {

    @Test
    public void should_park_a_car_return_get_a_ticket() {  //预估：5min 实际：6min
        //Given
        Car car  = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(2);
        //When
        Ticket ticket = parkingBoy.parkCar(car,parkingLot);
        //Then
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void should_park_car_to_second_position_when_first_parking_lot_is_full() { //预估：20min 实际：30min
        //Given
        Car car1  = new Car();
        Car car2  = new Car();
        Car car3  = new Car();

        ParkingBoy parkingBoy = new StupidParkingboy();

        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);

        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        //When
        parkingBoy.parkCar(car1,parkingLots);
        parkingBoy.parkCar(car2,parkingLots);
        parkingBoy.parkCar(car3,parkingLots);

        //Then
        Assertions.assertEquals(2,parkingLot1.getCars().size());
        Assertions.assertEquals(1,parkingLot2.getCars().size());
    }

    @Test
    public void should_park_car_to_position_has_more_lot() { //预估：5min 实际：5min
        //Given
        Car car1  = new Car();
        Car car2  = new Car();
        Car car3  = new Car();

        ParkingBoy parkingBoy = new CleverParkingboy();

        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);

        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        //When
        parkingBoy.parkCar(car1,parkingLots);
        parkingBoy.parkCar(car2,parkingLots);

        //Then
        Assertions.assertEquals(1,parkingLot2.getCars().size());
    }

    @Test
    public void should_park_car_to_position_has_larger_available_position_rate () { //预估：8min 实际：15min
        //Given
        Car car1  = new Car();
        Car car2  = new Car();
        Car car3  = new Car();
        Car car4  = new Car();

        ParkingBoy parkingBoy = new MoreCleverParkingboy();

        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(5);

        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);


        //When
        parkingBoy.parkCar(car1,parkingLots);
        parkingBoy.parkCar(car2,parkingLots);
        parkingBoy.parkCar(car3,parkingLots);
        parkingBoy.parkCar(car4,parkingLots);

        //Then
        Assertions.assertEquals(3,parkingLot2.getCars().size());
    }

}
