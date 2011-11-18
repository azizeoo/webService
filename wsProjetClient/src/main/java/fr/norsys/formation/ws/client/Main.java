package fr.norsys.formation.ws.client;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.norsys.formation.ws.sm.wsInterface.IUserServiceSm;
import fr.norsys.formation.ws.sq.schema.beans.UserGen;
public class Main {

	public static void main(final String[] args) {

		ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext(new String[] {"ClientContext.xml"});
		IUserServiceSm service = (IUserServiceSm) context.getBean("userServiceSm");
		String nomFoo = "Foo";
		//service 1
		System.out.println(service.sayHello(nomFoo));
		//service 2
		List<UserGen> list = service.getUsersByName("Foo");
		System.out.println("Liste des  utilisateurs avec le nom :");
		for(UserGen userGen: list){
			System.out.println(userGen.getId() + " " + userGen.getName());
		}
	}
}
