package com.hcl.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
	
	 public List<Booking> findBybookingDateBetween(LocalDate from, LocalDate to);
	 
	 public List<Booking> findByUserEmailEquals(String userEmail);

}
