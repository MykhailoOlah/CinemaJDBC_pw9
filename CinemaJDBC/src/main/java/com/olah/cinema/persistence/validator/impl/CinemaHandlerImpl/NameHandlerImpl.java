package com.olah.cinema.persistence.validator.impl.CinemaHandlerImpl;

import com.olah.cinema.persistence.entity.Cinema;
import com.olah.cinema.persistence.validator.contract.CinemaHandler;

public class NameHandlerImpl implements CinemaHandler {

	private CinemaHandler nextCinemaHandler;
	private static final int MIN_NAME_LENGTH = 5;
	private static final int MAX_NAME_LENGTH = 50;

	@Override
	public void validate(Cinema cinema) {
		String name = cinema.getName();
		if (name == null || name.isEmpty()) {
			cinema.getValidationMessages().add("Назва кінотеатру не може бути порожньою");
		} else if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			cinema.getValidationMessages().add(
			    "Назва кінотеатру повинна бути в межах від " + MIN_NAME_LENGTH + " до "
				  + MAX_NAME_LENGTH + " символів");
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