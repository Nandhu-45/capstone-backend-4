package com.hcl.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;


import com.hcl.entity.Booking;
import com.hcl.repository.BookingRepo;

@Service
public class BookingService {

	@Autowired
	BookingRepo bookingRepo;

	// show bookings
	public List<Booking> getAllBookings() {

		return bookingRepo.findAll();
	}

	//delete booking by Id
	public void deleteBooking(int id) {
		bookingRepo.deleteById(id);
	}

	//get all bookings by user email
	public List<Booking> getAllBookingsByUser(String userEmail) {
		List<Booking> bookings = bookingRepo.findByUserEmailEquals(userEmail);
		return bookings;
		
	}

	// get booking by booking-id
	public Optional<Booking> GetByBookingId(int id) {
		return bookingRepo.findById(id);
	}

	// adding booking
	public Booking addBooking(int id, String pickUpLocation, String droppingLocation, int kms, LocalDate bookingDate,
			String regNumber, String userName, String userEmail) {
		Booking booking = new Booking(id,pickUpLocation,droppingLocation, kms, bookingDate,regNumber,userName,userEmail);
        bookingRepo.save(booking);
		return booking;
	}

	// booking within dates
	public List<Booking> getwithindate(LocalDate from, LocalDate to) {
		return bookingRepo.findBybookingDateBetween(from, to);
	}

	// booking today date
	public List<Booking> findByTodayBooking(LocalDate from, LocalDate to) {

		List<Booking> bookingtoday = bookingRepo.findBybookingDateBetween(from, to);
		return bookingtoday;
	}
}
