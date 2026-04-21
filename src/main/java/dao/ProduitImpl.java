package dao;

import java.util.ArrayList;
import java.util.List;

/**
 *  * Implémentation concrète de ProduitDAO utilisant une liste en mémoire.  *
 * Utile pour tester l'application sans base de données.  * Chaque produit
 * ajouté se voit attribuer un identifiant unique automatiquement.  
 */

public class ProduitImpl implements ProduitDAO {
	private List<Produit> produits = new ArrayList<Produit>(); // Liste simulant la BDD

	/**
	 * Initialisation de quelques produits pour test.
     * Méthode appelée par Tomcat au démarrage.
	 */
	public void init() {
		System.out.println("Spring IOC est bien fonctionnée !");
		
		addProduit(new Produit("PC 1","Sony vaio 1",7000.0));
		addProduit(new Produit("PC 2","Sony vaio 2",6000.0));
	}

	/**
	 * Ajouter un produit à la liste.
	 * @param p Le produit à ajouter
	 * L'ID est généré automatiquement (size + 1)
	 */
	@Override
	public void addProduit(Produit p) {
		p.setIdProduit(new Long(produits.size() + 1));
		produits.add(p);
	}

	/**
	 * Supprimer un produit par son ID
	 * @param id Identifiant du produit à supprimer
	 */
	@Override
	public void deleteProduit(long id) {
		produits.remove(getProduitById(id));
		// Variante commentée: suppression via boucle explicite
		/*
		for(Produit p:produits){
			if(p.getIdProduit().equals(id)){
				produits.remove(p);
				break;
			}
		}
		*/
	}

	/**
	 * Récupérer un produit via son ID
	 * @param id Identifiant du produit
	 * @return Produit correspondant ou null si non trouvé
	 */
	@Override
	public Produit getProduitById(long id) {
		Produit produit = null;
		for(Produit p : produits){
			if(p.getIdProduit() == id){
				produit = p;
				break; // on arrête la boucle dès qu'on trouve le produit
			}
		}
		return produit;
	}

	/**
	 * Récupérer tous les produits
	 * @return Liste complète des produits
	 */
	@Override
	public List<Produit> getAllProduits() {
		return produits;
	}

	/**
	 * Mettre à jour un produit existant
	 * @param p Produit contenant les nouvelles informations
	 */
	@Override
	public void updateProduit(Produit p) {
		for (int i = 0; i < produits.size(); i++) {
			Produit existingProduit = produits.get(i);
			if (existingProduit.getIdProduit() == p.getIdProduit()) {
				// Mise à jour des champs
				existingProduit.setNom(p.getNom());
				existingProduit.setDescription(p.getDescription());
				existingProduit.setPrix(p.getPrix());
				break; // on sort après mise à jour
			}
		}

	}

}
