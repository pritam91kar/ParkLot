package com.skillenza.parkinglotjava;

import java.util.List;

import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin()
@RequestMapping("/api")
public class ParkingLotController {
	
	@Autowired
	ParkingLotRepository parkingLotRepository;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public List<ParkingLot> viewAllPark() {
		List<ParkingLot> s = parkingLotRepository.findAll();
		System.out.println(s);
		return s;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public void addPark(@RequestBody ParkingLot parkingLot) {
		System.out.println(parkingLot.getParking_amount());
		parkingLotRepository.save(parkingLot);
		
	}
}

