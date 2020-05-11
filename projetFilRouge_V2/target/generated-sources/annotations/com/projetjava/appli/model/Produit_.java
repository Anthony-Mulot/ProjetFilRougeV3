package com.projetjava.appli.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produit.class)
public abstract class Produit_ {

	public static volatile SingularAttribute<Produit, Integer> prix;
	public static volatile SingularAttribute<Produit, Date> dateAjout;
	public static volatile SingularAttribute<Produit, String> description;
	public static volatile SingularAttribute<Produit, Integer> id;
	public static volatile SingularAttribute<Produit, String> nom;
	public static volatile SingularAttribute<Produit, Integer> quantite;
	public static volatile SingularAttribute<Produit, Boolean> promotion;

	public static final String PRIX = "prix";
	public static final String DATE_AJOUT = "dateAjout";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String NOM = "nom";
	public static final String QUANTITE = "quantite";
	public static final String PROMOTION = "promotion";

}

