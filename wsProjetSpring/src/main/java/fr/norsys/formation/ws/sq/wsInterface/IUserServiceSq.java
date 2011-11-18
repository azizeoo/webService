package fr.norsys.formation.ws.sq.wsInterface;

import fr.norsys.formation.ws.sq.schema.beans.GetUsersByNameRequest;
import fr.norsys.formation.ws.sq.schema.beans.GetUsersByNameResponse;
import fr.norsys.formation.ws.sq.schema.beans.SayHelloRequest;
import fr.norsys.formation.ws.sq.schema.beans.SayHelloResponse;

public interface IUserServiceSq {
	public final static String NAMESPACE = "http://www.norsys.fr/formation/ws/sq/schema/beans";
	public final static String GET_USERS_BY_NAME_REQUEST = "getUsersByNameRequest";
	public final static String SAY_HELLO_REQUEST = "sayHelloRequest";
	
	SayHelloResponse getUsersByName(SayHelloRequest request);
	
	GetUsersByNameResponse getUsersByName(GetUsersByNameRequest request);
}
