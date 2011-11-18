package fr.norsys.formation.ws.dao.wsInterface;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import fr.norsys.formation.ws.dao.wsModel.User;

@WebService
@SOAPBinding(style=Style.RPC)
public interface IUserServiceDao {
	String sayHello(String name);
	User[] getUsersByName(String name);
}
