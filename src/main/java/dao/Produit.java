package dao;

/**
 * Classe représentant un produit dans l'application. Cette classe sert de
 * modèle pour le CRUD. Chaque instance correspond à un produit unique avec ses
 * propriétés.
 */

public class Produit {
	private long idProduit; // Identifiant unique du produit (généralement auto-incrémenté en BDD)
	private String nom; // Nom du produit
	private String description; // Description détaillée du produit
	private double prix; // Prix du produit

	// Constructeur vide requis par Spring et JSP pour créer des objets
	// dynamiquement
	public Produit() {
		super();
	}

	// Constructeur utile pour créer rapidement un produit sans ID (ex: lors de
	// l'ajout)
	public Produit(String nom, String description, double prix) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
	}

	// --- Getters et Setters ---
	// Ils permettent à Spring MVC et aux JSP de lier automatiquement les valeurs

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}
