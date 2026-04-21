package services;

import dao.*;

public class LoginMetier {
	// Instance unique pour le singleton
    private static LoginMetier instance;
    
    // Référence vers la couche DAO
	private UserDAO userDao;
	
	/*
     * Constructeur privé pour le singleton.
     * Initialise le DAO et précharge les produits via init().
     */
    private LoginMetier() {
        userDao = new UserImpl();
        ((UserImpl) userDao).init(); // Précharge des produits au démarrage
    }

    /*
     * Méthode pour récupérer l'instance unique du singleton.
     * Si elle n'existe pas, on la crée.
     */
    public static LoginMetier getInstance() {
        if (instance == null) {
            instance = new LoginMetier();
        }
        return instance;
    }

	public boolean verifierIdentifiants(String email, String password) {
		User u = userDao.getUser(email, password);
		if (u != null)
			return true;
		return false;
	}
	
	public String getRole(String email, String password) {
		User u = userDao.getUser(email, password);
		return u.getRole();
	}
}
