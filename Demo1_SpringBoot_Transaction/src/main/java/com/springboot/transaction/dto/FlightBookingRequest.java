package com.springboot.transaction.dto;

import com.springboot.transaction.entity.PassengerInfo;
import com.springboot.transaction.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
	
	private PassengerInfo passengerInfo;
	
	private PaymentInfo paymentInfo;
	
}
