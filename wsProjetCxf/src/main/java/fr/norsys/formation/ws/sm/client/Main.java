package fr.norsys.formation.ws.sm.client;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.norsys.formation.ws.sm.wsInterface.IUserServiceSm;
import fr.norsys.formation.ws.sq.schema.beans.UserGen;




public class Main {
	

	private static ClassPathXmlApplicationContext context = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		IUserServiceSm client = (IUserServiceSm) context.getBean("userServiceSq");
		List<UserGen> listUser = client.getUsersByName("Foo");	

		System.out.println("Liste des users depuis le WS Spring : ");
		for(UserGen user : listUser){
			System.out.println(user.getId() + " " + user.getName());
		}
	}


}
