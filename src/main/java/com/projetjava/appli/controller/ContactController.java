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
public class ContactController {

    @Autowired
    ProduitDAO produitDAO;

    @Autowired
    ContactDAO contactDAO;

    @Autowired
    RoleDAO roleDAO;
    
    @Autowired
    UtilisateurDAO<Utilisateur> utilisateurDAO;
    
    @Autowired

    CommandeDAO commandeDAO;


    @GetMapping("/liste-contact")
    public String listeProduit(Model model, Principal principal) {


        model.addAttribute("titre", "Liste des contacts");
        model.addAttribute("contacts", contactDAO.findAll());
        model.addAttribute ( "role" ,roleDAO.findAll());
        model.addAttribute("commandes",commandeDAO.findAll());
        model.addAttribute("produits",produitDAO.findAll());

        if (principal != null) {
            Utilisateur utilisateur = utilisateurDAO.findByEmail(principal.getName()).orElse(null);
            model.addAttribute("role", utilisateur.getRole().getName());
        }else {
            model.addAttribute("role", "Anonyme");
        }




        return "liste-contact";
    }

    @GetMapping({"/comme/edit-contact", "/comme/edit-contact/{id}"})
    public String editcontact(Model model, @PathVariable Optional<Integer> id) {


        Contact contact;

        if(id.isPresent()){
            contact = contactDAO.findById(id.get()).orElse(null);
        }else {
            contact = new Contact();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit contacts" : "Nous contacter");
        model.addAttribute("contact",contact);
        model.addAttribute ( " roles " ,roleDAO.findAll());
        model.addAttribute("produits",produitDAO.findAll());
        model.addAttribute("commandes",commandeDAO.findAll());
        model.addAttribute("contacts", contactDAO.findAll());




        return "/edit-contact";
    }

    @PostMapping("/edit/edit-contact")
    public String editcontact(@ModelAttribute("contact") Contact contact){

        contact = contactDAO.saveAndFlush(contact);

        return "redirect:/liste-contact";
    }


    @GetMapping("/admin/suppression-contact/{id}")
    public String delcontact(@PathVariable Integer id){
        contactDAO.deleteById(id);

        return "redirect:/liste-contact";
    }
}
