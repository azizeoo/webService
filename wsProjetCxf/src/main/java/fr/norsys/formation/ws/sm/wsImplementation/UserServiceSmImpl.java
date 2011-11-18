package fr.norsys.formation.ws.sm.wsImplementation;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.norsys.formation.ws.sm.wsInterface.IUserServiceSm;
import fr.norsys.formation.ws.sq.schema.beans.UserGen;

public class UserServiceSmImpl implements IUserServiceSm {

	final static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "ApplicationContext.xml" });
	final static IUserServiceSm service = (IUserServiceSm) context.getBean("userServiceSq");

	@Override
	public String sayHello(String name) {
		return service.sayHello(" |>> SrvSM "  + name);
	}

	@Override
	public List<UserGen> getUsersByName(String name) {
		return service.getUsersByName(name);
	}
}
