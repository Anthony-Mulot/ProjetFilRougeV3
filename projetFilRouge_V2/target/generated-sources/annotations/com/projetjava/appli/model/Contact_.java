package com.projetjava.appli.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contact.class)
public abstract class Contact_ {

	public static volatile SingularAttribute<Contact, String> informationCommande;
	public static volatile SingularAttribute<Contact, String> priseContact;
	public static volatile SingularAttribute<Contact, Produit> produit;
	public static volatile SingularAttribute<Contact, Utilisateur> utilisateur;
	public static volatile SingularAttribute<Contact, String> description;
	public static volatile SingularAttribute<Contact, Integer> id;
	public static volatile SingularAttribute<Contact, String> informationProduit;
	public static volatile SingularAttribute<Contact, Commande> commande;
	public static volatile SingularAttribute<Contact, String> autre;

	public static final String INFORMATION_COMMANDE = "informationCommande";
	public static final String PRISE_CONTACT = "priseContact";
	public static final String PRODUIT = "produit";
	public static final String UTILISATEUR = "utilisateur";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String INFORMATION_PRODUIT = "informationProduit";
	public static final String COMMANDE = "commande";
	public static final String AUTRE = "autre";

}

