package fr.norsys.formation.ws.sq.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.norsys.formation.ws.sq.client.generated.IUserServiceDao;
import fr.norsys.formation.ws.sq.client.generated.User;
import fr.norsys.formation.ws.sq.client.generated.UserArray;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://localhost:8888/userServiceDao?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		QName qname = new QName(
				"http://wsImplementation.dao.ws.formation.norsys.fr/",
				"UserServiceDaoImplService");

		Service service = null;
		if (null != url) {
			service = Service.create(url, qname);
		} else {
			System.out.println("L'URL n'a pu etre cree, l'appel au WS JAVA ne peut donc pas se faire.");
		}

		IUserServiceDao iUserServiceDao = null;
		if (null != service) {
			iUserServiceDao = service.getPort(IUserServiceDao.class);
		} else {
			System.out.println("Le service n'a pu etre cree, l'appel au WS JAVA ne peut donc pas se faire.");
		}

		if (null != iUserServiceDao) {
			String nameFoo = "Foo";
			UserArray listUsers = iUserServiceDao.getUsersByName("Foo");
			System.out.println("All users with name " + nameFoo + " :");
			for (User user : listUsers.getItem()) {
				System.out.println(user.getId() + " " + user.getName());
			}
		} else {
			System.out.println("WS Java non initialise.");
		}
	}

}
