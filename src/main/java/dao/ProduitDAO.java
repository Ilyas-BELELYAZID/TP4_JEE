package dao;

import java.util.List;

/**
 * Interface DAO pour la gestion des produits. Définit les opérations CRUD sans
 * préciser la méthode de persistance. L'implémentation concrète peut être en
 * mémoire, JDBC, JPA, etc.
 */

public interface ProduitDAO {

	/**
	 * Ajouter un nouveau produit
	 * 
	 * @param p Le produit à ajouter
	 */
	public void addProduit(Produit p);

	/**
	 * Supprimer un produit par son identifiant
	 * 
	 * @param id L'identifiant du produit à supprimer
	 */
	public void deleteProduit(long id);

	/**
	 * Récupérer un produit à partir de son identifiant
	 * 
	 * @param id L'identifiant du produit
	 * @return Le produit correspondant ou null si non trouvé
	 */
	public Produit getProduitById(long id);

	/**
	 * Récupérer la liste de tous les produits
	 * 
	 * @return Liste complète des produits
	 */
	public List<Produit> getAllProduits();

	/**
	 * Mettre à jour un produit existant
	 * 
	 * @param p Produit avec les nouvelles informations (l'id doit être renseigné)
	 */
	public void updateProduit(Produit p);

}