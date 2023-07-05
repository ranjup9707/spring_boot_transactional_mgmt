package com.springboot.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.transaction.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String>{

}
