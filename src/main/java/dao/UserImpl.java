package dao;

import java.util.ArrayList;
import java.util.List;

public class UserImpl implements UserDAO {

	public static List<User> bd = new ArrayList<>();
	
	/**
	 * Initialisation de quelques produits pour test.
     * Méthode appelée par Tomcat au démarrage.
	 */
	public void init() {
		ajouterUser(new User("ilyas","belelyazid","ilyasbelelyazid@gmail.com","123", "admin"));
		ajouterUser(new User("abc","abc","abc@gmail.com","ensah", "client"));
	}

	@Override
	public void ajouterUser(User user) {
		bd.add(user);
	}

	@Override
	public User getUser(String email, String password) {
		for (User u : bd)
			if (u.getEmail().equals(email) && u.getPassword().equals(password))
				return u;
		return null;
	}

	@Override
	public User getUser(String email) {
		for (User u : bd)
			if (u.getEmail().equals(email))
				return u;
		return null;
	}

	@Override
	public void supprimerUser(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modifierUser(User user) {
		// TODO Auto-generated method stub
	}
}
