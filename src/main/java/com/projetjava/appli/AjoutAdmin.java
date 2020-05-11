package com.projetjava.appli;

import com.projetjava.appli.dao.UtilisateurDAO;
import com.projetjava.appli.model.Role;
import com.projetjava.appli.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AjoutAdmin implements ApplicationRunner {

    @Autowired
    UtilisateurDAO utilisateurDAO;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Utilisateur utilisateur = new Utilisateur();
//        Role role = new Role();
//        role.setId(5);
//        utilisateur.setPassword("ROOT");
//        utilisateur.setEmail("Antho@test.fr");
//        utilisateur.setRole(role);
//        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
//        utilisateurDAO.saveAndFlush(utilisateur);

    }
}
