package com.hcl.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.OwnerConfirmation;
import com.hcl.repository.OwnerConfirmationRepo;

@Service
public class OwnerConfirmationService {

	@Autowired
	OwnerConfirmationRepo ownerConfirmationRepo;

	// add owner booking confirmation
	public OwnerConfirmation addBookingconfo(int ownerconfirmationId, String pickUpLocation, String droppingLocation,
			int kms, LocalDate ownerconfirmationDate, String regNumber, String userName, String userEmail) {
		OwnerConfirmation bookingc = new OwnerConfirmation(ownerconfirmationId,pickUpLocation,droppingLocation,kms, ownerconfirmationDate, regNumber, userName, userEmail);
        ownerConfirmationRepo.save(bookingc);
		return bookingc;
	}

		public List<OwnerConfirmation> getAllBookingconfo(){
		   return	ownerConfirmationRepo.findAll();
		}
}
