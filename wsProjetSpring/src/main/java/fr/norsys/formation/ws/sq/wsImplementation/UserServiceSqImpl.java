package fr.norsys.formation.ws.sq.wsImplementation;

import java.math.BigInteger;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import fr.norsys.formation.ws.sq.client.UserJavaApi;
import fr.norsys.formation.ws.sq.client.generated.User;
import fr.norsys.formation.ws.sq.schema.beans.GetUsersByNameRequest;
import fr.norsys.formation.ws.sq.schema.beans.GetUsersByNameResponse;
import fr.norsys.formation.ws.sq.schema.beans.SayHelloRequest;
import fr.norsys.formation.ws.sq.schema.beans.SayHelloResponse;
import fr.norsys.formation.ws.sq.schema.beans.UserGen;
import fr.norsys.formation.ws.sq.wsInterface.IUserServiceSq;

@Endpoint
public class UserServiceSqImpl implements IUserServiceSq {

	@Override
	@PayloadRoot(localPart = SAY_HELLO_REQUEST, namespace = NAMESPACE)
	public SayHelloResponse getUsersByName(SayHelloRequest request) {
		UserJavaApi userJavaApi = new UserJavaApi();
		String reponse = userJavaApi.sayHello(request.getName());
		SayHelloResponse sayHelloResponse = new SayHelloResponse();
		sayHelloResponse.setName(" |>> SrvSQ " + reponse);
		return sayHelloResponse;
	}

	@Override
	@PayloadRoot(localPart = GET_USERS_BY_NAME_REQUEST, namespace = NAMESPACE)
	public GetUsersByNameResponse getUsersByName(GetUsersByNameRequest request) {

		UserJavaApi userJavaApi = new UserJavaApi();
		User[] listUser = userJavaApi.getUsersByName(request.getName());
		GetUsersByNameResponse getUsersByNameResponse = new GetUsersByNameResponse();
		for (User user : listUser) {
			UserGen userGen = new UserGen();
			UserApiJAVAToUserSpring(user, userGen);
			getUsersByNameResponse.getUserGen().add(userGen);
		}
		return getUsersByNameResponse;
	}

	private void UserApiJAVAToUserSpring(User user, UserGen userGen) {
		userGen.setId(new BigInteger(String.valueOf(user.getId())));
		userGen.setName(user.getName());
	}
}
