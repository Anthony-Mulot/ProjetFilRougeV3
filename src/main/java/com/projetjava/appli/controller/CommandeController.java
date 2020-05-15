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
public class CommandeController {

    @Autowired
    PaiementDAO  paiementDAO;

    @Autowired
    ProduitDAO produitDAO;

    @Autowired
    CommandeDAO commandeDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    UtilisateurDAO<Utilisateur> utilisateurDAO;

    @Autowired

    ContactDAO contactDAO;


    @GetMapping("/liste-commande")
    public String listeCommande(Model model, Principal principal) {


        model.addAttribute("titre", "liste des commandes");
        model.addAttribute("commandes", commandeDAO.findAll());
        model.addAttribute ( "roles",roleDAO.findAll());
        model.addAttribute("contacts",contactDAO.findAll());
        model.addAttribute("produits",produitDAO.findAll());

        if (principal != null) {
            Utilisateur utilisateur = utilisateurDAO.findByEmail(principal.getName()).orElse(null);
            model.addAttribute("role", utilisateur.getRole().getName());
        }else {
            model.addAttribute("role", "Anonyme");
        }



        return "liste-commande";
    }

    @GetMapping({"/comme/edit-commande", "/comme/edit-commande/{id}"})
    public String editCommande(Model model, @PathVariable Optional<Integer> id) {


        Commande commande;

        if(id.isPresent()){
            commande = commandeDAO.findById(id.get()).orElse(null);
        }else {
            commande = new Commande();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit commandes" : "Nouvelle commande");
        model.addAttribute("commande",commande);
        model.addAttribute ( " roles " ,roleDAO.findAll());
        model.addAttribute("produits",produitDAO.findAll());
        model.addAttribute("commandes",commandeDAO.findAll());
        model.addAttribute("contacts", contactDAO.findAll());
        model.addAttribute("paiements", paiementDAO.findAll());




        return "/edit-commande";
    }

    @PostMapping("/comme/edit-commande")
    public String editCommande(@ModelAttribute("commande") Commande commande){

        commande = commandeDAO.saveAndFlush(commande);

        return "redirect:/liste-commande";
    }


    @GetMapping("/admin/suppression-commande/{id}")
    public String delCommande(@PathVariable Integer id){
        commandeDAO.deleteById(id);

        return "redirect:/liste-commande";
    }
}
