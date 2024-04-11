package com.olah.cinema.persistence.validator.impl.FilmHandlerImpl;

import com.olah.cinema.persistence.entity.Film;
import com.olah.cinema.persistence.validator.contract.FilmHandler;

public class FilmNameHandlerImpl implements FilmHandler {
	private FilmHandler nextFilmHandler;

	@Override
	public void validate(Film film) {
		if (film.getName() == null || film.getName().isEmpty()) {
			film.getValidationMessages().add("Назва фільму не може бути порожньою");
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
