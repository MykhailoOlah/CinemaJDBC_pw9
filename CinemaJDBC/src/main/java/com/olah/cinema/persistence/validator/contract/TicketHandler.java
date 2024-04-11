package com.olah.cinema.persistence.validator.contract;

import com.olah.cinema.persistence.entity.Ticket;
import com.olah.cinema.persistence.validator.Handler;

public interface TicketHandler extends Handler<Ticket, TicketHandler> {

	@Override
	void validate(Ticket ticket);

	@Override
	void setNextHandler(TicketHandler ticketHandler);
}