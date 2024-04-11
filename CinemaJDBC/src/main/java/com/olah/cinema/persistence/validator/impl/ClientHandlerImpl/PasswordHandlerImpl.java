package com.olah.cinema.persistence.validator.impl.ClientHandlerImpl;

import com.olah.cinema.persistence.entity.Client;
import com.olah.cinema.persistence.validator.contract.ClientHandler;

public class PasswordHandlerImpl implements ClientHandler {
	private ClientHandler nextClientHandler;

	@Override
	public void validate(Client client) {
		if(client.getPassword() == null){
			client.getValidationMessages().add("Пароль не може бути пустим");
		} else if (client.getPassword().length() < 8){
			client.getValidationMessages().add("Пароль повинен містити принаймні 8 символів");
		}
		if (nextClientHandler != null) {
			nextClientHandler.validate(client);
		}
	}

	@Override
	public void setNextHandler(ClientHandler clientHandler) {
		nextClientHandler = clientHandler;
	}
}
