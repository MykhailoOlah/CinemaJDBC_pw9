package com.olah.cinema.persistence.validator.impl.FilmHandlerImpl;

import com.olah.cinema.persistence.entity.Film;
import com.olah.cinema.persistence.validator.contract.FilmHandler;

public class RatingHandlerImpl implements FilmHandler {
	private FilmHandler nextFilmHandler;

	@Override
	public void validate(Film film) {
		if (film.getRating() < 0 || film.getRating() > 10) {
			film.getValidationMessages().add("Рейтинг фільму має бути в межах від 0 до 10");
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
