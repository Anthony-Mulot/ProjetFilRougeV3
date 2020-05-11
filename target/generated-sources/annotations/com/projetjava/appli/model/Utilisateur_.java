package com.projetjava.appli.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Utilisateur.class)
public abstract class Utilisateur_ {

	public static volatile SingularAttribute<Utilisateur, String> password;
	public static volatile SingularAttribute<Utilisateur, Role> role;
	public static volatile SingularAttribute<Utilisateur, Date> dateNaissance;
	public static volatile SingularAttribute<Utilisateur, String> name;
	public static volatile SingularAttribute<Utilisateur, String> nickname;
	public static volatile SingularAttribute<Utilisateur, String> adresse;
	public static volatile SingularAttribute<Utilisateur, String> telephone;
	public static volatile SingularAttribute<Utilisateur, Integer> nombreCommandePasse;
	public static volatile SingularAttribute<Utilisateur, Integer> id;
	public static volatile SingularAttribute<Utilisateur, String> email;
	public static volatile SingularAttribute<Utilisateur, String> Ville;
	public static volatile SingularAttribute<Utilisateur, Date> dateCreationCompte;

	public static final String PASSWORD = "password";
	public static final String ROLE = "role";
	public static final String DATE_NAISSANCE = "dateNaissance";
	public static final String NAME = "name";
	public static final String NICKNAME = "nickname";
	public static final String ADRESSE = "adresse";
	public static final String TELEPHONE = "telephone";
	public static final String NOMBRE_COMMANDE_PASSE = "nombreCommandePasse";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String VILLE = "Ville";
	public static final String DATE_CREATION_COMPTE = "dateCreationCompte";

}

