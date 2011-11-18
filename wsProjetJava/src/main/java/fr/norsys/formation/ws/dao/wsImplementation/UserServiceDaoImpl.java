package fr.norsys.formation.ws.dao.wsImplementation;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import fr.norsys.formation.ws.dao.wsInterface.IUserServiceDao;
import fr.norsys.formation.ws.dao.wsModel.User;

@WebService(endpointInterface = "fr.norsys.formation.ws.dao.wsInterface.IUserServiceDao")
public class UserServiceDaoImpl implements IUserServiceDao {
	private User[] listUsers;

	public UserServiceDaoImpl() {
		listUsers = new User[5];
		listUsers[0] = new User(1, "Foo");
		listUsers[1] = new User(2, "Bar");
		listUsers[2] = new User(3, "Toto");
		listUsers[3] = new User(4, "Foo");
		listUsers[4] = new User(5, "Titi");
	}

	public String sayHello(String name) {
		return "Hello |>> SrvDAO " + name;
	}

	public User[] getUsersByName(String name) {
		User[] tabUsersSearch = null;
		List<User> listUsersSearch = new ArrayList<User>();
		for (int i = 0; i < listUsers.length; i++) {
			if (listUsers[i].getName().equals(name)) {
				listUsersSearch.add(listUsers[i]);
			}
		}
		tabUsersSearch = new User[listUsersSearch.size()];
		int i = 0;
		for (User user : listUsersSearch) {
			tabUsersSearch[i] = user;
			i++;
		}
		return tabUsersSearch;
	}

}
