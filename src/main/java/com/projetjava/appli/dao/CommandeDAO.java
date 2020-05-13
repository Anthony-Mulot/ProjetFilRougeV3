package com.projetjava.appli.dao;

import com.projetjava.appli.model.Commande;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDAO extends JpaRepository<Commande,Integer> {
}
