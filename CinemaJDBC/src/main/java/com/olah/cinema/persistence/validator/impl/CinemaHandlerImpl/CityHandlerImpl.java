package com.olah.cinema.persistence.validator.impl.CinemaHandlerImpl;

import com.olah.cinema.persistence.entity.Cinema;
import com.olah.cinema.persistence.validator.contract.CinemaHandler;

public class CityHandlerImpl implements CinemaHandler {
	private CinemaHandler nextCinemaHandler;
	private static final int MIN_CITY_LENGTH = 3;
	private static final int MAX_CITY_LENGTH = 50;

	@Override
	public void validate(Cinema cinema) {
		String city = cinema.getCity();
		if (city == null || city.isEmpty()) {
			cinema.getValidationMessages().add("Місто кінотеатру не може бути порожнім");
		} else if (city.length() < MIN_CITY_LENGTH || city.length() > MAX_CITY_LENGTH) {
			cinema.getValidationMessages().add("Місто кінотеатру повинно містити від " + MIN_CITY_LENGTH + " до " + MAX_CITY_LENGTH + " символів");
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
