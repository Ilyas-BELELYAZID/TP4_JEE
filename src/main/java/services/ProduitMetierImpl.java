package services;

import java.util.List;

import dao.Produit;
import dao.ProduitDAO;
import dao.ProduitImpl;

/*
 * Implémentation concrète de la couche métier (service layer).
 * Cette classe sert d'intermédiaire entre la couche Web (Servlets/JSP)
 * et la couche DAO (ProduitDAO). Elle encapsule la logique métier.
 *
 * Elle utilise le pattern Singleton pour s'assurer qu'il n'y ait qu'une
 * seule instance de la couche métier, ce qui permet de partager la même
 * liste de produits préchargée entre toutes les servlets.
 */

public class ProduitMetierImpl implements ProduitMetier {

	// Instance unique pour le singleton
    private static ProduitMetierImpl instance;

    // Référence vers la couche DAO
    private ProduitDAO dao;
    
    /*
     * Constructeur privé pour le singleton.
     * Initialise le DAO et précharge les produits via init().
     */
    private ProduitMetierImpl() {
        dao = new ProduitImpl();
        ((ProduitImpl) dao).init(); // Précharge des produits au démarrage
    }

    /*
     * Méthode pour récupérer l'instance unique du singleton.
     * Si elle n'existe pas, on la crée.
     */
    public static ProduitMetierImpl getInstance() {
        if (instance == null) {
            instance = new ProduitMetierImpl();
        }
        return instance;
    }

    /*
     * Ajouter un produit via le DAO.
     */
    @Override
    public void addProduit(Produit p) {
        dao.addProduit(p);
    }

    /*
     * Supprimer un produit via le DAO.
     */
    @Override
    public void deleteProduit(Long id) {
        dao.deleteProduit(id);
    }

    /*
     * Récupérer la liste complète des produits via le DAO.
     */
    @Override
    public List<Produit> getAllProduits() {
        return dao.getAllProduits();
    }
    
    /*
     * Récupérer un produit par son identifiant via le DAO.
     */
    @Override
    public Produit getProduitById(Long id) {
        return dao.getProduitById(id);
    }

    /*
     * Mettre à jour un produit existant via le DAO.
     */
    @Override
    public void updateProduit(Produit p) {
        dao.updateProduit(p);
    }
}
