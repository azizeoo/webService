package fr.norsys.formation.ws.sm.wsInterface;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.norsys.formation.ws.sq.schema.beans.UserGen;

@WebService
public interface IUserServiceSm {
	@WebMethod(operationName="sayHello")
	String sayHello(String name);
	@WebMethod(operationName="getUsersByName")
	List<UserGen> getUsersByName(String name);
}
