package com.projetjava.appli.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Paiement.class)
public abstract class Paiement_ {

	public static volatile SingularAttribute<Paiement, Integer> id;
	public static volatile SingularAttribute<Paiement, Commande> commande;
	public static volatile SingularAttribute<Paiement, String> nom;

	public static final String ID = "id";
	public static final String COMMANDE = "commande";
	public static final String NOM = "nom";

}

