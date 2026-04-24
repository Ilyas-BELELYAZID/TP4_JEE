package services;

import dao.*;

public class RegisterMetier {
	
	// Instance unique pour le singleton
    private static RegisterMetier instance;
    
    // Référence vers la couche DAO
	private UserDAO userDao;
	
	/*
     * Constructeur privé pour le singleton.
     * Initialise le DAO et précharge les produits via init().
     */
    private RegisterMetier() {
        userDao = new UserImpl();
        ((UserImpl) userDao).init(); // Précharge des produits au démarrage
    }

    /*
     * Méthode pour récupérer l'instance unique du singleton.
     * Si elle n'existe pas, on la crée.
     */
    public static RegisterMetier getInstance() {
        if (instance == null) {
            instance = new RegisterMetier();
        }
        return instance;
    }
	
	public boolean RegisterUser(User user) {
		User u = userDao.getUser(user.getEmail());
		if(u == null) {
			userDao.ajouterUser(user);
			return true;
		}
		return false;
	}
}
