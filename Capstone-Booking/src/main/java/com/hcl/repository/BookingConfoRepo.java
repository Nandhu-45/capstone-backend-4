package com.hcl.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.BookingConfirmation;
@Repository
public interface BookingConfoRepo extends JpaRepository<BookingConfirmation, Integer> {
	 List<BookingConfirmation> findByconfirmDateBetween(LocalDate from, LocalDate to);

     public BookingConfirmation findByUserNameAndUserEmail(String userName, String userEmail);



}
