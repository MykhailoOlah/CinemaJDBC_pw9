package com.olah.cinema.persistence;

import com.olah.cinema.persistence.entity.Cinema;
import com.olah.cinema.persistence.entity.Client;
import com.olah.cinema.persistence.entity.Film;
import com.olah.cinema.persistence.entity.Ticket;
import com.olah.cinema.persistence.validator.impl.CinemaHandlerImpl.AddressHandlerImpl;
import com.olah.cinema.persistence.validator.impl.CinemaHandlerImpl.CityHandlerImpl;
import com.olah.cinema.persistence.validator.impl.CinemaHandlerImpl.NameHandlerImpl;
import com.olah.cinema.persistence.validator.impl.ClientHandlerImpl.FullNameHandlerImpl;
import com.olah.cinema.persistence.validator.impl.ClientHandlerImpl.PasswordHandlerImpl;
import com.olah.cinema.persistence.validator.impl.ClientHandlerImpl.PhoneNumberHandlerImpl;
import com.olah.cinema.persistence.validator.impl.FilmHandlerImpl.DescriptionHandlerImpl;
import com.olah.cinema.persistence.validator.impl.FilmHandlerImpl.FilmNameHandlerImpl;
import com.olah.cinema.persistence.validator.impl.FilmHandlerImpl.FilmReleaseYearHandlerImpl;
import com.olah.cinema.persistence.validator.impl.FilmHandlerImpl.GenreHandlerImpl;
import com.olah.cinema.persistence.validator.impl.FilmHandlerImpl.RatingHandlerImpl;
import com.olah.cinema.persistence.validator.impl.TicketHandlerImpl.RowNumberHandlerImpl;
import com.olah.cinema.persistence.validator.impl.TicketHandlerImpl.SeatNumberHandlerImpl;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		//cinemaValidateTest();
		//clientValidateTest();
		//filmValidateTest();
		//TicketValidateTest();
	}

	private static void TicketValidateTest() {
		RowNumberHandlerImpl rowNumberHandler = new RowNumberHandlerImpl();
		SeatNumberHandlerImpl seatNumberHandler = new SeatNumberHandlerImpl();

		rowNumberHandler.setNextHandler(seatNumberHandler);

		Ticket ticket = Ticket.builder()
		    .id(1)
		    .rowNumber(2)
		    .seatNumber(3)
		    .build();

		rowNumberHandler.validate(ticket);

		printValidationMessagesIfAny(ticket.getValidationMessages());
	}

	private static void filmValidateTest() {
		FilmNameHandlerImpl filmNameHandler = new FilmNameHandlerImpl();
		FilmReleaseYearHandlerImpl filmReleaseYearHandler = new FilmReleaseYearHandlerImpl();
		GenreHandlerImpl genreHandler = new GenreHandlerImpl();
		DescriptionHandlerImpl descriptionHandler = new DescriptionHandlerImpl();
		RatingHandlerImpl ratingHandler = new RatingHandlerImpl();

		filmNameHandler.setNextHandler(filmReleaseYearHandler);
		filmReleaseYearHandler.setNextHandler(genreHandler);
		genreHandler.setNextHandler(descriptionHandler);
		descriptionHandler.setNextHandler(ratingHandler);

		Film film = Film.builder()
		    .id(1)
		    .name("Test film")
		    .releaseYear(1931)
		    .genre("Test genre")
		    .description("Test desc")
		    .rating(4)
		    .build();

		filmNameHandler.validate(film);

		printValidationMessagesIfAny(film.getValidationMessages());
	}

	private static void clientValidateTest() {
		FullNameHandlerImpl fullNameHandler = new FullNameHandlerImpl();
		PasswordHandlerImpl passwordHandler = new PasswordHandlerImpl();
		PhoneNumberHandlerImpl phoneNumberHandler = new PhoneNumberHandlerImpl();

		fullNameHandler.setNextHandler(passwordHandler);
		passwordHandler.setNextHandler(phoneNumberHandler);

		Client client = Client.builder()
		    .id(1)
		    .fullname("tttttttttttt")
		    .password("Test password")
		    .phoneNumber("Teste")
		    .build();

		fullNameHandler.validate(client);

		printValidationMessagesIfAny(client.getValidationMessages());
	}

	private static void cinemaValidateTest() {
		AddressHandlerImpl addressHandler = new AddressHandlerImpl();
		CityHandlerImpl cityHandler = new CityHandlerImpl();
		NameHandlerImpl nameHandler = new NameHandlerImpl();

		addressHandler.setNextHandler(cityHandler);
		cityHandler.setNextHandler(nameHandler);

		Cinema cinema = Cinema.builder()
		    .cinemaId(1)
		    .name("Testtt")
		    .address("ttttt")
		    .city("Tttt")
		    .build();

		addressHandler.validate(cinema);

		printValidationMessagesIfAny(cinema.getValidationMessages());
	}

	public static void printValidationMessagesIfAny(List<String> validationMessages) {
		if (validationMessages != null && !validationMessages.isEmpty()) {
			System.out.println("Помилки: ");
			for (String validateMessage : validationMessages) {
				System.out.println("    - " + validateMessage);
			}
		} else {
			System.out.println("Успішне створення!");
		}
	}
}
