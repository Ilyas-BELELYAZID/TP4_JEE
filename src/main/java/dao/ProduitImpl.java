package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

/**
 * Implémentation Hibernate du DAO Produit.
 *
 * Chaque méthode ouvre une Session Hibernate, effectue l'opération dans
 * une Transaction, puis ferme la Session dans un bloc finally pour garantir
 * la libération des ressources même en cas d'exception.
 *
 * Pattern de gestion des transactions Hibernate :
 *   Session session = factory.openSession();
 *   Transaction tx = null;
 *   try {
 *       tx = session.beginTransaction();
 *       // ... opération ...
 *       tx.commit();
 *   } catch (Exception e) {
 *       if (tx != null) tx.rollback(); // annule en cas d'erreur
 *       throw new RuntimeException(e); // propage au Service
 *   } finally {
 *       session.close(); // toujours fermer la session
 *   }
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
     * Insère un nouveau produit en base via session.save().
     * Hibernate génère automatiquement l'INSERT SQL.
     */
    @Override
    public void addProduit(Produit produit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(produit); // INSERT INTO produits (...)
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback(); // Annule l'insertion si erreur
            throw new RuntimeException("Erreur lors de l'ajout du produit", e);
        } finally {
            session.close(); // Libère la connexion au pool
        }
    }

    /**
     * Met à jour un produit existant via session.update().
     * Hibernate génère automatiquement l'UPDATE SQL basé sur l'ID.
     */
    @Override
    public void updateProduit(Produit produit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(produit); // UPDATE produits SET ... WHERE id_produit = ?
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Erreur lors de la mise à jour du produit id=" + produit.getIdProduit(), e);
        } finally {
            session.close();
        }
    }

    /**
     * Supprime un produit par son ID.
     * On charge d'abord le produit (findById), puis on le supprime.
     * session.delete() requiert un objet attaché à la session courante.
     */
    @Override
    public void deleteProduit(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            // get() retourne null si l'ID n'existe pas (contrairement à load() qui lève une exception)
            Produit produit = (Produit) session.get(Produit.class, id);
            if (produit != null) {
                session.delete(produit); // DELETE FROM produits WHERE id_produit = ?
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Erreur lors de la suppression du produit id=" + id, e);
        } finally {
            session.close();
        }
    }

    /**
     * Charge un produit par son ID sans transaction (lecture seule).
     * session.get() : retourne null si non trouvé (comportement sûr).
     */
    @Override
    public Produit getProduitById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Produit) session.get(Produit.class, id); 
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la recherche du produit id=" + id, e);
        } finally {
            session.close();
        }
    }

    /**
     * Récupère tous les produits via une requête HQL (Hibernate Query Language).
     * "from Produit" est l'équivalent HQL de "SELECT * FROM produits".
     */
    @Override
    @SuppressWarnings("unchecked") // cast List<Produit> depuis query.list()
    public List<Produit> getAllProduits() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // HQL : utilise le nom de la CLASSE Java, pas le nom de la table SQL
            return session.createQuery("from Produit order by idProduit").list();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des produits", e);
        } finally {
            session.close();
        }
    }

}
