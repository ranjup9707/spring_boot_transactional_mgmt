package com.springboot.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.transaction.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long>{

}
