package com.olah.cinema.persistence.validator.contract;

import com.olah.cinema.persistence.entity.Film;
import com.olah.cinema.persistence.validator.Handler;

public interface FilmHandler extends Handler<Film, FilmHandler> {

	@Override
	void validate(Film film);

	@Override
	void setNextHandler(FilmHandler filmHandler);
}
