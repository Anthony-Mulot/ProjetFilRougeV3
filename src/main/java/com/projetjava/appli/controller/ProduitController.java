package com.projetjava.appli.controller;
import com.projetjava.appli.dao.*;
import com.projetjava.appli.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class ProduitController {

    @Autowired
    ProduitDAO produitDAO;

    @Autowired
    RoleDAO roleDAO;


    @Autowired
    UtilisateurDAO<Utilisateur> utilisateurDAO;


//    @Autowired
//
//    CommandeDAO commandeDAO;


    @GetMapping("/liste-produit")
    public String listeProduit(Model model) {


        model.addAttribute("titre", "liste des produits");
        model.addAttribute("produits", produitDAO.findAll());


        return "liste-produit";
    }

    @GetMapping({"/edit/edit-produit", "/edit/edit-produit /{id}"})
    public String editproduit(Model model, @PathVariable Optional<Integer> id) {


        Produit produit;
//        Commande commande;
        Utilisateur utilisateur;


        if(id.isPresent()){
            produit = produitDAO.findById(id.get()).orElse(null);
        }else {
            produit = new Produit();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit produits" : "Nouveau produit");
        model.addAttribute("produit",produit);



        return "edit-produit";
    }

    @PostMapping("/edit/edit-produit")
    public String editproduit(@ModelAttribute("produit") Produit produit){

        produit = produitDAO.saveAndFlush(produit);

        return "redirect:/liste-produit";
    }


    @GetMapping("/edit/suppression-produit/{id}")
    public String delproduit(@PathVariable Integer id){
        produitDAO.deleteById(id);

        return "redirect:/liste-produit";
    }
}
