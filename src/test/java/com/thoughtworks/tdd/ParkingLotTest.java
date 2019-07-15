package com.thoughtworks.tdd;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;


public class ParkingLotTest {



    @Test
    public void should_get_a_ticket_and_return_a_car() { //预估：5min 实际：5min
        //Given
        Car car = new Car();
        Ticket ticket = new Ticket(car);
        ParkingBoy parkingBoy = new ParkingBoy();
        //When
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.addCar(car,ticket);

        //Then
        Assertions.assertNotNull(parkingBoy.returnCar(ticket,parkingLot));
    }

    @Test
    public void should_return_cars_with_correspond_ticket() { //预估：10min 实际：10min
        //Given
        Car car1  = new Car();
        Car car2  = new Car();

        Ticket ticket1 = new Ticket(car1);
        Ticket ticket2 = new Ticket(car2);

        //When
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.addCar(car1,ticket1);
        parkingLot.addCar(car2,ticket2);

        //Then
        Assertions.assertEquals(car1,parkingBoy.returnCar(ticket1,parkingLot));
        Assertions.assertEquals(car2,parkingBoy.returnCar(ticket2,parkingLot));

    }

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
        Assertions.assertEquals(null,parkingBoy.returnCar(wrongTicket,parkingLot)); // wrong ticket
        Assertions.assertEquals(null,parkingBoy.returnCar(null,parkingLot)); // no ticket

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

        //When
        //parkingLot.addCar(car1,ticket1);
       // parkingLot.addCar(car2,ticket2);

        Car returnCar1 = parkingBoy.returnCar(ticket1,parkingLot); //ticket1 has been used!!!
        Car returnCar2 = parkingBoy.returnCar(ticket1,parkingLot);

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
        parkingBoy.returnCar(wrongTicket,parkingLot);

        //Then
        Assertions.assertEquals("Unrecognized parking ticket.",parkingLot.getMessage()); // wrong ticket
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
        parkingBoy.returnCar(null,parkingLot);

        //Then
        Assertions.assertEquals("Please provide your parking ticket.",parkingLot.getMessage()); // no ticket
    }



    @Test
    public void add_parking_boys_to_management_list() {  //预估：8min 实际：10min
        //Given
        Car car1 = new Car();
        Car car2 = new Car();

        ParkingLot parkingLot = new ParkingLot(2);

        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();

        parkingLot.setParkingBoylist(parkingBoy1);
        parkingLot.setParkingBoylist(parkingBoy2);

        //When
        Ticket ticket1 = parkingBoy1.parkCar(car1, parkingLot);
        Ticket ticket2 = parkingBoy2.parkCar(car2, parkingLot);

        Car returnCar1 = parkingBoy1.returnCar(ticket1, parkingLot); //ticket1 has been used!!!
        Car returnCar2 = parkingBoy2.returnCar(ticket2, parkingLot);

        //Then
        Assertions.assertEquals(car1, returnCar1);
        Assertions.assertEquals(car2, returnCar2);
    }

    @Test
    public void add_manager_to_parking_lot() {  //预估：8min 实际：10min
        //Given
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        Manager manager1 = new Manager("danny");
        Manager manager2 = new Manager("leo");


        ParkingLot parkingLot1 = new ParkingLot(manager1,2);
        ParkingLot parkingLot2 = new ParkingLot(manager2,2);

        //When
        Ticket ticket1 = manager1.parkCar(car1, parkingLot1);
        Ticket ticket2 = manager1.parkCar(car2, parkingLot1);
        Ticket ticket3 = manager2.parkCar(car3, parkingLot2);

        Car returnCar1 = manager1.returnCar(ticket1, parkingLot1); //ticket1 has been used!!!
        Car returnCar2 = manager2.returnCar(ticket3, parkingLot2);

        //Then
        Assertions.assertEquals(car1, returnCar1);
        Assertions.assertEquals(car3, returnCar2);
    }
}
