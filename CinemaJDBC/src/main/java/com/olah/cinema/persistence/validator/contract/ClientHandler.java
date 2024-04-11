package com.olah.cinema.persistence.validator.contract;

import com.olah.cinema.persistence.entity.Client;
import com.olah.cinema.persistence.validator.Handler;

public interface ClientHandler extends Handler<Client, ClientHandler> {

	@Override
	void validate(Client client);

	@Override
	void setNextHandler(ClientHandler clientHandler);
}
