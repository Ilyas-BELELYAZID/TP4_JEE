package dao;

public interface UserDAO {
	User getUser(String email, String password);
	
	User getUser(String email);
	
	void ajouterUser(User user);

	void supprimerUser(User user);

	void modifierUser(User user);
}
