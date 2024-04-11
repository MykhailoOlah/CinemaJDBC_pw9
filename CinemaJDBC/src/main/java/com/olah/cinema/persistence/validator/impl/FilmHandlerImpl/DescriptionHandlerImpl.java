package com.olah.cinema.persistence.validator.impl.FilmHandlerImpl;

import com.olah.cinema.persistence.entity.Film;
import com.olah.cinema.persistence.validator.contract.FilmHandler;

public class DescriptionHandlerImpl implements FilmHandler {
	private FilmHandler nextFilmHandler;

	@Override
	public void validate(Film film) {
		if (film.getDescription() == null || film.getDescription().isEmpty()) {
			film.getValidationMessages().add("Опис фільму не може бути порожнім");
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
