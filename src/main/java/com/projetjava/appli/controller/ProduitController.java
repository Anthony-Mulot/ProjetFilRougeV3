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

import java.security.Principal;
import java.util.Optional;


@Controller
public class ProduitController {

    @Autowired
    ProduitDAO produitDAO;

    @Autowired
    RoleDAO roleDAO;


    @Autowired
    UtilisateurDAO<Utilisateur> utilisateurDAO;


    @Autowired

    CommandeDAO commandeDAO;


    @GetMapping("/liste-produit")
    public String listeProduit(Model model , Principal principal) {


        model.addAttribute("titre", "Liste des produits");
        model.addAttribute("produits", produitDAO.findAll());
        model.addAttribute ( "roles" ,roleDAO.findAll());

        if (principal != null) {
            Utilisateur utilisateur = utilisateurDAO.findByEmail(principal.getName()).orElse(null);
            model.addAttribute("role", utilisateur.getRole().getName());
        }else {
            model.addAttribute("role", "Anonyme");
        }


        return "liste-produit";
    }

    @GetMapping({"/comme/edit-produit", "/comme/edit-produit/{id}"})
    public String editproduit(Model model, Principal principal, @PathVariable Optional<Integer> id) {


        Produit produit;


        if (principal != null) {
            Utilisateur utilisateur = utilisateurDAO.findByEmail(principal.getName()).orElse(null);
            model.addAttribute("role", utilisateur.getRole().getName());
        }else {
            model.addAttribute("role", "Anonyme");
        }

        if(id.isPresent()){
            produit = produitDAO.findById(id.get()).orElse(null);
        }else {
            produit = new Produit();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit produits" : "Nouveau produit");
        model.addAttribute("produit",produit);
        model.addAttribute ( " roles " ,roleDAO.findAll());




        return "/edit-produit";
    }

    @PostMapping("/edit/edit-produit")
    public String editproduit(@ModelAttribute("produit") Produit produit){

        produit = produitDAO.saveAndFlush(produit);

        return "redirect:/liste-produit";
    }


    @GetMapping("/admin/suppression-produit/{id}")
    public String delproduit(@PathVariable Integer id){
        produitDAO.deleteById(id);

        return "redirect:/liste-produit";
    }
}
