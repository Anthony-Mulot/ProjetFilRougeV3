package com.projetjava.appli.dao;


import com.projetjava.appli.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDAO extends JpaRepository<Paiement,Integer> {
}
