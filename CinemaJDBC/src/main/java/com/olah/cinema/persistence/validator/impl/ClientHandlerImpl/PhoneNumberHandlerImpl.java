package com.olah.cinema.persistence.validator.impl.ClientHandlerImpl;

import com.olah.cinema.persistence.entity.Client;
import com.olah.cinema.persistence.validator.contract.ClientHandler;

public class PhoneNumberHandlerImpl implements ClientHandler {
	private ClientHandler nextClientHandler;

	@Override
	public void validate(Client client) {
		if(client.getPhoneNumber() == null){
			client.getValidationMessages().add("Номер телефону не може бути пустим");
		} else if (client.getPhoneNumber().length() != 10){
			client.getValidationMessages().add("Номер телефону повинен складатися з 10 цифр");
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
