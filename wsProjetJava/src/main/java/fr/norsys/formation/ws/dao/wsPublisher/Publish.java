package fr.norsys.formation.ws.dao.wsPublisher;

import javax.xml.ws.Endpoint;

import fr.norsys.formation.ws.dao.wsImplementation.UserServiceDaoImpl;
import fr.norsys.formation.ws.dao.wsInterface.IUserServiceDao;

public class Publish {
	public static final String URI = "http://localhost:8888/userServiceDao";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IUserServiceDao service = new UserServiceDaoImpl();
		
		Endpoint endpoint = Endpoint.publish(URI, service);
		
		boolean status = endpoint.isPublished();
		System.out.println("WebService JAVA disponible ? = " + status);
	}

}
