package com.olah.cinema.persistence.validator.impl.FilmHandlerImpl;

import com.olah.cinema.persistence.entity.Film;
import com.olah.cinema.persistence.validator.contract.FilmHandler;

public class FilmReleaseYearHandlerImpl implements FilmHandler {
	private FilmHandler nextFilmHandler;

	@Override
	public void validate(Film film) {
		if (film.getReleaseYear() <= 0) {
			film.getValidationMessages().add("Рік випуску фільму має бути більшим за 0");
		}
		if (nextFilmHandler != null) {
			nextFilmHandler.validate(film);
		}
	}

	@Override
	public void setNextHandler(FilmHandler filmHandler) {
		nextFilmHandler = filmHandler;
	}
}
