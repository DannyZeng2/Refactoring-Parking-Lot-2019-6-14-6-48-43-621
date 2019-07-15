package com.thoughtworks.tdd;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;


public class ErrorMessageTest {

    @Test
    public void should_not_return_cars_with_wrong_or_no_ticket() { //预估：5min 实际：5min
        //Given
        Car car1  = new Car();
        Ticket ticket1 = new Ticket(car1);
        Ticket wrongTicket = new Ticket(new Car());
        //When
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.addCar(car1,ticket1);

        //Then
        Assertions.assertEquals(null,parkingBoy.fetchCar(wrongTicket,parkingLot));
        Assertions.assertEquals(null,parkingBoy.fetchCar(null,parkingLot));

    }

    @Test
    public void should_not_return_cars_if_ticket_used() {  //预估：8min 实际：10min
        //Given
        Car car1  = new Car();
        Car car2  = new Car();

        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(2);

        Ticket ticket1 = parkingBoy.parkCar(car1,parkingLot);
        Ticket ticket2 = parkingBoy.parkCar(car2,parkingLot);

        Car returnCar1 = parkingBoy.fetchCar(ticket1,parkingLot);
        Car returnCar2 = parkingBoy.fetchCar(ticket1,parkingLot);

        //Then
        Assertions.assertEquals(car1,returnCar1);
        Assertions.assertEquals(null,returnCar2);

    }

    @Test
    public void should_not_park_cars_if_capacity_is_full() {  //预估：8min 实际：12min
        //Given
        Car car1  = new Car();
        Car car2  = new Car();
        Car car3  = new Car();

        Ticket ticket1 = new Ticket(car1);
        Ticket ticket2 = new Ticket(car2);
        Ticket ticket3 = new Ticket(car3);

        ParkingLot parkingLot = new ParkingLot(2);

        //When
        parkingLot.addCar(car1,ticket1);
        parkingLot.addCar(car2,ticket2);
        parkingLot.addCar(car3,ticket3);

        //Then
        Assertions.assertEquals( "Not enough position.",parkingLot.getMessage());
    }
    @Test
    public void should_sent_massage_when_sent_wrong_ticket() { //预估：10min 实际：10min
        //Given
        Car car  = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(2);

        Ticket wrongTicket = new Ticket(new Car());

        //When
        parkingBoy.parkCar(car,parkingLot);
        parkingBoy.fetchCar(wrongTicket,parkingLot);

        //Then
        Assertions.assertEquals("Unrecognized parking ticket.",parkingLot.getMessage());
    }

    @Test
    public void should_sent_massage_when_not_provide_ticket() {  //预估：5min 实际：5min
        //Given
        Car car  = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(2);


        //When
        Ticket ticket = parkingBoy.parkCar(car,parkingLot);
       //parkingLot.addCar(car1,ticket1);
        parkingBoy.fetchCar(null,parkingLot);

        //Then
        Assertions.assertEquals("Please provide your parking ticket.",parkingLot.getMessage());
    }

}
