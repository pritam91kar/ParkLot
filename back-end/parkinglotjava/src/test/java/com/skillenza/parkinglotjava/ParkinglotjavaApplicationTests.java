package com.skillenza.parkinglotjava;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkinglotjavaApplicationTests {

	@Test
	public void viewAllParkLot() {
	    
		ParkingLot parkLot = new ParkingLot(1,null, 12, 60, 180, null, 1234);
		ParkingLotController p = new ParkingLotController();
		List<ParkingLot> listOfParkLot = new ArrayList<ParkingLot>();
		listOfParkLot.add(new ParkingLot(1,null, 12, 60, 180, null, 1234));
		p.addPark(parkLot);
		assertEquals(listOfParkLot.get(0), parkLot);
		
	}
	
 //your test goes here


}
