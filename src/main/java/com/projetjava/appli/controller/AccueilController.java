package com.projetjava.appli.controller;

import com.projetjava.appli.dao.RoleDAO;
import com.projetjava.appli.dao.UtilisateurDAO;
import com.projetjava.appli.model.Role;
import com.projetjava.appli.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Optional;

@Controller
public class AccueilController {

    @Autowired
    UtilisateurDAO<Utilisateur> utilisateurDAO;

    @Autowired
    RoleDAO roleDAO;



    @GetMapping("/")
    public String accueil(Model model, Principal principal) {

        model.addAttribute("utilisateurs", utilisateurDAO.findAll());
        model.addAttribute("roles", roleDAO.findAll());


        if (principal != null) {
            Utilisateur utilisateur = utilisateurDAO.findByEmail(principal.getName()).orElse(null);
            model.addAttribute("role", utilisateur.getRole().getName());
        }else {
            model.addAttribute("role", "Anonyme");
        }
        return "accueil";
    }

    @GetMapping({"/comme/edit-utilisateur/{id}"})
    public String editUtilisateurClient(Model model, @PathVariable Optional<Integer> id) {

        Utilisateur utilisateur;

        utilisateur = utilisateurDAO.findById(id.get()).orElse(null);


        model.addAttribute("titre", id.isPresent() ? "Edit utilisateurs" : "Modifier mon compte");
        model.addAttribute("roles", roleDAO.findAll());
        model.addAttribute("utilisateurs",utilisateurDAO.findAll());
        model.addAttribute("utilisateur", utilisateur);



        return "edit-utilisateur";
    }

    @GetMapping("/admin/hello")
    public String hello(Model model){
        model.addAttribute("hello", "Hello");

        return "accueil";
    }
}
