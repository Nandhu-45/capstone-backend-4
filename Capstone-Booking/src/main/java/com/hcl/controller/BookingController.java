package com.hcl.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Booking;
import com.hcl.entity.BookingConfirmation;
import com.hcl.entity.OwnerConfirmation;
import com.hcl.service.BookingConfirmService;
import com.hcl.service.BookingService;
import com.hcl.service.OwnerConfirmationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@Autowired
	BookingConfirmService bookingConfirmService;

	@Autowired
	OwnerConfirmationService ownerConfirmationService;


	//***********************Bookings***************************//

	// add the booking
	@GetMapping("/addbooking")
	public Booking addbooking(int id, String pickUpLocation, String droppingLocation, int kms, String bookingDate,
			String regNumber, String userName, String userEmail) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate localDate = LocalDate.parse(bookingDate);

		return bookingService.addBooking(id, pickUpLocation, droppingLocation, kms, localDate, regNumber, userName, userEmail);

	}

	// get booking by booking id
	@GetMapping("/getBybookingID")
	public Optional<Booking> getBookingbyId(int bookingId) {

		return bookingService.GetByBookingId(bookingId);
	}

	// get today's bookings
	LocalDate todaydate = LocalDate.now();
	@GetMapping("/getBookingtoday")
	public List<Booking> FindBybookingToday() {

		return bookingService.findByTodayBooking(todaydate, todaydate);
	}

	//get all bookings
	@GetMapping("/allBookings")
	public List<Booking> allBookingd() {

		return bookingService.getAllBookings();
	}

	//get bookings with in date
	@GetMapping("/getwithindate")
	public List<Booking> bookingWithin(String from, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate localDatefrom = LocalDate.parse(from, formatter);
		LocalDate localDateto = LocalDate.parse(to, formatter);

		return bookingService.getwithindate(localDatefrom, localDateto);
	}

	//get booking by user
	@GetMapping("/bookingsByUser")
	public List<Booking> getAllBookingsByUser(String email) {
		return bookingService.getAllBookingsByUser(email);
	}


	// delete booking by Id
	@GetMapping("/deleteBookingById")
	public String deleteBooking1(int id) {
		bookingService.deleteBooking(id);
		return "successfully Deleted";
	}

	// ***********************************Confirm booking************************************//
	// owner add confirmation
	@GetMapping("/owneraddConfirmations")
	public OwnerConfirmation addbookingownerconfo(int ownerconfirmationId, String pickUpLocation,
			String droppingLocation, int kms, String ownerconfirmationDate, String regNumber, String userName,
			String userEmail) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate localDate = LocalDate.parse(ownerconfirmationDate);
		return ownerConfirmationService.addBookingconfo(ownerconfirmationId, pickUpLocation, droppingLocation, kms, localDate, regNumber,
				userName, userEmail);

	}

	// owner get confirmation
	@GetMapping("/getownerConfirmations")
	public List<OwnerConfirmation> getAllBookingconfo(){
		   return	ownerConfirmationService.getAllBookingconfo();
		   }

	//delete confirm booking
	@GetMapping("/deleteConfoBooking")
	public String deleteConfoBooking(int id) {
		bookingConfirmService.deleteConfirmedBooking(id);
		return "successfully Deleted";
	}

	// get confirmed booking by id
	@GetMapping("/getbyconfirmationID")
	public Optional<BookingConfirmation> getBookingConfobyId(int confirmId) {

		return bookingConfirmService.GetByBookingConfoId(confirmId);
	}

	// get the confirmed today's bookings
	LocalDate todaydateconfo = LocalDate.now();
	@GetMapping("/getBookingConfirmtoday")
	public List<BookingConfirmation> FindBybookingConfoToday() {

		return bookingConfirmService.findByTodayBookingconfo(todaydateconfo, todaydateconfo);
	}

	// get all the Confirmed bookings
	@GetMapping("/getAllConfirmedBookings")
	public List<BookingConfirmation> getAllConfirmedBookings() {

		return bookingConfirmService.getAllBookingsconfo();
	}

	//get Confirmations with in the date of booking
	@GetMapping("/getwithindateConfirmation")
	public List<BookingConfirmation> bookingConfoWithin(String from, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate localDatefrom = LocalDate.parse(from, formatter);
		LocalDate localDateto = LocalDate.parse(to, formatter);

		return bookingConfirmService.getwithindateconfo(localDatefrom, localDateto);
	}
	
	
	

	// for confirmation of user
	@GetMapping("/confirmBooking")
	public String bookingconfirm(BookingConfirmation bookingconfirm) {
		return bookingConfirmService.ConfirmBooking(bookingconfirm);
	}

	// add the new confirmation
	@GetMapping("/addnewconfirmations")
	public BookingConfirmation addbookingConfo(int confirmId, String pickUpLocation, String droppingLocation, int kms,
			String confirmDate, String regNumber, String userName, String userEmail) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate localDate = LocalDate.parse(confirmDate);

		return bookingConfirmService.addBookingconfo(confirmId, pickUpLocation, droppingLocation, kms, localDate, regNumber, userName,
				userEmail);

	}


}
