package com.olah.cinema.persistence.validator.impl.ClientHandlerImpl;

import com.olah.cinema.persistence.entity.Client;
import com.olah.cinema.persistence.validator.contract.ClientHandler;

public class FullNameHandlerImpl implements ClientHandler {
	private ClientHandler nextClientHandler;
	@Override
	public void validate(Client client) {
		if(client.getFullname() == null){
			client.getValidationMessages().add("ПІБ не може бути пустим");
		}else if (client.getFullname().length() <= 10){
			client.getValidationMessages().add("ПІБ не може бути меншим ніж 10 символів");
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
