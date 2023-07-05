package com.springboot.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.transaction.dto.FlightBookingAcknowledgment;
import com.springboot.transaction.dto.FlightBookingRequest;
import com.springboot.transaction.service.FlightBookingService;

@RestController
public class FlightBookingController {
	
	@Autowired
	private FlightBookingService flightBookingService;
	
	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgment bookFlightTicket(@RequestBody FlightBookingRequest request) {
		return flightBookingService.bookFlightTicket(request);
	}
	
}
