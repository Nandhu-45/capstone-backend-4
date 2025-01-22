package com.hcl.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.BookingConfirmation;
import com.hcl.repository.BookingConfoRepo;

@Service
public class BookingConfirmService {

	@Autowired
	BookingConfoRepo bookingConfoRepo;

	// add booking confirmation
	public BookingConfirmation addBookingconfo(int confirmId, String pickUpLocation, String droppingLocation, int kms,
			LocalDate confirmDate, String regNumber, String userName, String userEmail) {
		BookingConfirmation bookingc = new BookingConfirmation(confirmId,pickUpLocation,droppingLocation,kms,confirmDate,regNumber, userName, userEmail);
		bookingConfoRepo.save(bookingc);
		return bookingc;
	}

	// show bookings
	public List<BookingConfirmation> getAllBookingsconfo() {

		return bookingConfoRepo.findAll();
	}

	//delete booking by Id
	public void deleteConfirmedBooking(int id) {
		bookingConfoRepo.deleteById(id);
	}

	// get by id
	public Optional<BookingConfirmation> GetByBookingConfoId(int bookingconfId) {
		return bookingConfoRepo.findById(bookingconfId);
	}

	// get booking within dates
	public List<BookingConfirmation> getwithindateconfo(LocalDate from, LocalDate to) {
		return bookingConfoRepo.findByconfirmDateBetween(from, to);
	}

	// get booking today date
	public List<BookingConfirmation> findByTodayBookingconfo(LocalDate from, LocalDate to) {

		List<BookingConfirmation> bookingtoday = bookingConfoRepo.findByconfirmDateBetween(from, to);
		return bookingtoday;
	}

	// confirming booking by id
	public String ConfirmBooking(BookingConfirmation bc) {
		if (bookingConfoRepo.findByUserNameAndUserEmail(bc.getUserName(), bc.getUserEmail()) != null) {
			return "User Successfully confirmed booking ";
		} else {
			return "Booking cancelled";
		}
	}
}
