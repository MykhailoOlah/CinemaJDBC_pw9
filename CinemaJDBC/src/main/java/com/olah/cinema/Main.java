package com.olah.cinema;

import com.olah.cinema.persistence.dao.CinemaDao;
import com.olah.cinema.persistence.dao.ClientDao;
import com.olah.cinema.persistence.dao.FilmDao;
import com.olah.cinema.persistence.dao.TicketDao;
import com.olah.cinema.persistence.entity.Cinema;
import com.olah.cinema.persistence.entity.Client;
import com.olah.cinema.persistence.entity.Film;
import com.olah.cinema.persistence.entity.Ticket;
import java.util.List;

public class Main {
	private static final ClientDao clientDao = ClientDao.getInstance();
	private static final CinemaDao cinemaDao = CinemaDao.getInstance();
	private static final FilmDao filmDao = FilmDao.getInstance();
	private static final TicketDao tickedDao = TicketDao.getInstance();

	public static void main(String[] args) {
//		createClient();
//
		//allClients();
//
//		System.out.println(getClientById(1));
//
//		updateClient(getClientById(1));
//
//		deleteClient(1);

		/////////////////////////////////////////
		//createCinema();
//
//		allCinemas();
//
		//System.out.println(getCinemaById(1));
//
//		updateCinema(getCinemaById(1));
//
//		deleteCinema(1);
		/////////////////////////////////////////

//		createFilm();
//		allFilms();
		//System.out.println(getFilmById(1));
//		updateFilm(getFilmById(1));
//		deleteFilm(1);

		//////////////////////////////////////////

		//createTicket();
//		allTickets();
		//System.out.println(getTicketById(1));
//		updateTicket(getTicketById(1));
//		deleteTicket(2);

	}

	private static void createTicket() {
		Ticket ticket = Ticket.builder()
		    .rowNumber(1)
		    .seatNumber(2)
		    .client(getClientById(1))
		    .film(getFilmById(1))
		    .build();
		System.out.println(tickedDao.create(ticket));
	}

	private static void allTickets() {
		List<Ticket> allTickets = tickedDao.getAll();
		for (Ticket ticket : allTickets) {
			System.out.println(ticket);
		}
	}

	private static Ticket getTicketById(Integer id) {
		return tickedDao.getById(id);
	}

	private static void updateTicket(Ticket ticket) {
		ticket.setRowNumber(3);
		ticket.setSeatNumber(4);
		ticket.setClient(getClientById(2));
		ticket.setFilm(getFilmById(2));
		System.out.println(tickedDao.update(ticket));
	}

	private static void deleteTicket(Integer id) {
		System.out.println(tickedDao.delete(id));
	}
	private static void createFilm() {
		Film film = Film.builder()
		    .name("Назва фільму")
		    .releaseYear(2022)
		    .genre("Жанр")
		    .description("Опис")
		    .rating(5)
		    .cinema(getCinemaById(2))
		    .build();
		System.out.println(filmDao.create(film));
	}

	private static void allFilms() {
		List<Film> allFilms = filmDao.getAll();
		for (Film film : allFilms) {
			System.out.println(film);
		}
	}

	private static Film getFilmById(Integer id) {
		return filmDao.getById(id);
	}

	private static void updateFilm(Film film) {
		film.setName("Нова назва фільму");
		System.out.println(filmDao.update(film));
	}

	private static void deleteFilm(Integer id) {
		System.out.println(filmDao.delete(id));
	}
	private static void deleteCinema(Integer deleteCinemaId) {
		System.out.println(cinemaDao.delete(deleteCinemaId));
	}

	private static void updateCinema(Cinema cinema) {
		cinema.setName("Нова назва");
		System.out.println(cinemaDao.update(cinema));
	}

	private static Cinema getCinemaById(Integer id) {
		return cinemaDao.getById(id);
	}

	private static void allCinemas() {
		List<Cinema> allCinemas = cinemaDao.getAll();
		for (Cinema cinema : allCinemas) {
			System.out.println(cinema);
		}
	}

	private static void createCinema() {
		Cinema cinema = Cinema.builder()
		    .name("Новий кінотеатр")
		    .address("Адреса")
		    .city("Місто")
		    .build();
		System.out.println(cinemaDao.create(cinema));
	}
	private static void deleteClient(Integer deleteClientId) {
		System.out.println(clientDao.delete(deleteClientId));
	}

	private static void updateClient(Client client) {
		client.setFullname("Нове імя");
		System.out.println(clientDao.update(client));
	}

	private static Client getClientById(Integer id){
		return clientDao.getById(id);
	}
	private static void allClients() {
		List<Client> allClients = clientDao.getAll();
		for (Client client: allClients){
			System.out.println(client);
		}
	}

	private static void createClient() {
		Client client = Client.builder()
		    .fullname("Новий2024")
		    .password("1234")
		    .phoneNumber("+3098655456")
		    .build();
		System.out.println(clientDao.create(client));
	}
}
