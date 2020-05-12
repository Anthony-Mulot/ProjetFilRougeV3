package com.projetjava.appli.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String priseContact;
    private String informationProduit;
    private String informationCommande;
    private String description;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date dateAjout;


    @OneToOne
    private Commande commande;

    @ManyToOne
    private Produit produit;

    @OneToOne
    private Utilisateur utilisateur;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPriseContact() {
        return priseContact;
    }

    public void setPriseContact(String priseContact) {
        this.priseContact = priseContact;
    }

    public String getInformationProduit() {
        return informationProduit;
    }

    public void setInformationProduit(String informationProduit) {
        this.informationProduit = informationProduit;
    }

    public String getInformationCommande() {
        return informationCommande;
    }

    public void setInformationCommande(String informationCommande) {
        this.informationCommande = informationCommande;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}

