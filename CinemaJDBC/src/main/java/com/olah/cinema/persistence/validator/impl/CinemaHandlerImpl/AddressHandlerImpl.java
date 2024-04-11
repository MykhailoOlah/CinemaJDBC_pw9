package com.olah.cinema.persistence.validator.impl.CinemaHandlerImpl;

import com.olah.cinema.persistence.entity.Cinema;
import com.olah.cinema.persistence.validator.contract.CinemaHandler;

public class AddressHandlerImpl implements CinemaHandler {
	private CinemaHandler nextCinemaHandler;
	private static final int MIN_ADDRESS_LENGTH = 5;
	private static final int MAX_ADDRESS_LENGTH = 100;

	@Override
	public void validate(Cinema cinema) {
		String address = cinema.getAddress();
		if (address == null || address.isEmpty()) {
			cinema.getValidationMessages().add("Адреса кінотеатру не може бути порожньою");
		} else if (address.length() < MIN_ADDRESS_LENGTH || address.length() > MAX_ADDRESS_LENGTH) {
			cinema.getValidationMessages().add("Адреса кінотеатру повинна містити від " + MIN_ADDRESS_LENGTH + " до " + MAX_ADDRESS_LENGTH + " символів");
		}
		if (nextCinemaHandler != null) {
			nextCinemaHandler.validate(cinema);
		}
	}

	@Override
	public void setNextHandler(CinemaHandler cinemaHandler) {
		nextCinemaHandler = cinemaHandler;
	}
}
