package com.olah.cinema.persistence.validator.contract;

import com.olah.cinema.persistence.entity.Cinema;
import com.olah.cinema.persistence.validator.Handler;

public interface CinemaHandler extends Handler<Cinema, CinemaHandler> {

	@Override
	void validate(Cinema cinema);

	@Override
	void setNextHandler(CinemaHandler cinemaHandler);
}
