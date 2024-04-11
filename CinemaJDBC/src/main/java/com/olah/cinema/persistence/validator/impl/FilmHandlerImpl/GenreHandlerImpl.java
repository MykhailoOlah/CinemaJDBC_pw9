package com.olah.cinema.persistence.validator.impl.FilmHandlerImpl;

import com.olah.cinema.persistence.entity.Film;
import com.olah.cinema.persistence.validator.contract.FilmHandler;

public class GenreHandlerImpl implements FilmHandler{
	private FilmHandler nextFilmHandler;

	@Override
	public void validate(Film film) {
		if (film.getGenre() == null || film.getGenre().isEmpty()) {
			film.getValidationMessages().add("Жанр фільму не може бути порожнім");
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
