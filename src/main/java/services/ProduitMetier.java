package services;

import java.util.List;
import dao.Produit;

/**
 * Interface du service métier pour la gestion des produits.
 * Cette couche sert d’intermédiaire entre le DAO (accès aux données)
 * et le Controller (gestion des requêtes HTTP).
 * 
 * Elle peut contenir de la logique métier supplémentaire (validation, calculs, règles, etc.)
 */

public interface ProduitMetier {
	
	/**
	 * Ajouter un nouveau produit
	 * @param p Produit à ajouter
	 */
	public void addProduit(Produit p);
	
	/**
	 * Supprimer un produit par son ID
	 * @param id Identifiant du produit à supprimer
	 */
	public void deleteProduit(Long id);
	/**
	 * Récupérer la liste de tous les produits
	 * @return Liste des produits
	 */
	public List<Produit> getAllProduits();
	/**
	 * Récupérer un produit par son ID
	 * @param id Identifiant du produit
	 * @return Produit correspondant ou null si non trouvé
	 */
	public Produit getProduitById(Long id);
	/**
	 * Mettre à jour un produit existant
	 * @param p Produit avec nouvelles informations
	 */
	public void updateProduit(Produit p);

}
