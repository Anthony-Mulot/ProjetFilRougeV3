package com.projetjava.appli.dao;


import com.projetjava.appli.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurDAO <U extends Utilisateur> extends JpaRepository<U,Integer> {
    Optional<Utilisateur> findByEmail(String email);
}
