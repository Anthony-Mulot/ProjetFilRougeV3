package com.projetjava.appli.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Commande.class)
public abstract class Commande_ {

	public static volatile SingularAttribute<Commande, Produit> produit;
	public static volatile SingularAttribute<Commande, Utilisateur> utilisateur;
	public static volatile SingularAttribute<Commande, Boolean> isCommercial;
	public static volatile SingularAttribute<Commande, String> typePaiement;
	public static volatile SingularAttribute<Commande, String> statutCommande;
	public static volatile SingularAttribute<Commande, Integer> id;
	public static volatile SingularAttribute<Commande, Date> dateCommande;
	public static volatile SingularAttribute<Commande, String> nom;
	public static volatile SingularAttribute<Commande, String> commentaire;

	public static final String PRODUIT = "produit";
	public static final String UTILISATEUR = "utilisateur";
	public static final String IS_COMMERCIAL = "isCommercial";
	public static final String TYPE_PAIEMENT = "typePaiement";
	public static final String STATUT_COMMANDE = "statutCommande";
	public static final String ID = "id";
	public static final String DATE_COMMANDE = "dateCommande";
	public static final String NOM = "nom";
	public static final String COMMENTAIRE = "commentaire";

}

