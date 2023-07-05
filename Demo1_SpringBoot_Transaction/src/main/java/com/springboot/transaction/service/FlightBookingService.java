package com.springboot.transaction.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.transaction.dto.FlightBookingAcknowledgment;
import com.springboot.transaction.dto.FlightBookingRequest;
import com.springboot.transaction.entity.PassengerInfo;
import com.springboot.transaction.entity.PaymentInfo;
import com.springboot.transaction.repository.PassengerInfoRepository;
import com.springboot.transaction.repository.PaymentInfoRepository;
import com.springboot.transaction.utils.PaymentUtils;

@Service
public class FlightBookingService {
	
	@Autowired
	private PassengerInfoRepository passengerInfoRepo;
	
	@Autowired
	private PaymentInfoRepository paymentInfoRepo;
	
	@Transactional//(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public FlightBookingAcknowledgment bookFlightTicket(FlightBookingRequest request) {
		FlightBookingAcknowledgment acknowledgement = null;
		PassengerInfo passengerInfo = request.getPassengerInfo();
		passengerInfo = passengerInfoRepo.save(passengerInfo);
		
		PaymentInfo paymentInfo = request.getPaymentInfo();
		
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		paymentInfo.setPassengerId(passengerInfo.getPId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfo = paymentInfoRepo.save(paymentInfo);
		
		return new FlightBookingAcknowledgment("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
	}
}
