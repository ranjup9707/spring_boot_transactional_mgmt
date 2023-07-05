package com.springboot.transaction.utils;

import java.util.HashMap;
import java.util.Map;

import com.springboot.transaction.exception.InsufficientAmountException;

public class PaymentUtils {
	
	private static Map<String, Double> paymentMap = new HashMap<String, Double>();
	
	static 
	{
		paymentMap.put("acct1", 12000.00);
		paymentMap.put("acct2", 15000.00);
		paymentMap.put("acct3", 11000.00);
		paymentMap.put("acct4", 10000.00);
	}
	
	public static boolean validateCreditLimit(String acctNo, double paidAmount) {
		if(paidAmount > paymentMap.get(acctNo)) {
			throw new InsufficientAmountException("Insufficient Fund ....");
		}
		else
		{
			return true;
		}
	}
}
