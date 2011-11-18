package fr.norsys.formation.ws.sm.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;

import fr.norsys.formation.ws.sm.wsInterface.IUserServiceSm;
import fr.norsys.formation.ws.sq.schema.beans.GetUsersByNameRequest;
import fr.norsys.formation.ws.sq.schema.beans.GetUsersByNameResponse;
import fr.norsys.formation.ws.sq.schema.beans.ObjectFactory;
import fr.norsys.formation.ws.sq.schema.beans.SayHelloRequest;
import fr.norsys.formation.ws.sq.schema.beans.SayHelloResponse;
import fr.norsys.formation.ws.sq.schema.beans.UserGen;

public class UserServiceClient implements IUserServiceSm {

	private static final ObjectFactory WS_CLIENT_FACTORY = new ObjectFactory();
	@Autowired
	private WebServiceTemplate wsTemplate;

	public UserServiceClient(WebServiceTemplate webServiceTemplate) {
		this.wsTemplate = webServiceTemplate;
	}

	@Override
	public String sayHello(String name) {
		SayHelloRequest request = WS_CLIENT_FACTORY.createSayHelloRequest();
		request.setName(name);
		SayHelloResponse response = (SayHelloResponse) wsTemplate
				.marshalSendAndReceive(request);
		return response.getName();
	}

	@Override
	public List<UserGen> getUsersByName(String name) {
		GetUsersByNameRequest request = WS_CLIENT_FACTORY.createGetUsersByNameRequest();
		request.setName(name);
		GetUsersByNameResponse response = (GetUsersByNameResponse) wsTemplate.marshalSendAndReceive(request);
		return response.getUserGen();
	}
}
