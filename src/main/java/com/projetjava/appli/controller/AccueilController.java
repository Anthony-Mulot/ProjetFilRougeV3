package com.projetjava.appli.controller;

import com.projetjava.appli.dao.UtilisateurDAO;
import com.projetjava.appli.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
public class AccueilController {

    @Autowired
    UtilisateurDAO<Utilisateur> utilisateurDAO;

    @GetMapping("/")
    public String accueil(Model model, Principal principal) {
        if (principal != null) {
            Utilisateur utilisateur = utilisateurDAO.findByEmail(principal.getName()).orElse(null);
            model.addAttribute("role", utilisateur.getRole().getName());
        }else {
            model.addAttribute("role", "Anonyme");
        }
        return "accueil";
    }
    @GetMapping("/admin/hello")
    public String hello(Model model){
        model.addAttribute("hello", "Hello");

        return "accueil";
    }
}
