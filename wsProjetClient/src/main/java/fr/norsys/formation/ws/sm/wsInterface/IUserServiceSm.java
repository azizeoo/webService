package fr.norsys.formation.ws.sm.wsInterface;

import java.util.List;

import javax.jws.WebService;

import fr.norsys.formation.ws.sq.schema.beans.UserGen;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.1-b03- Generated
 * source version: 2.1
 * 
 */
@WebService
public interface IUserServiceSm {

	String sayHello(String name);

	List<UserGen> getUsersByName(String name);

}
