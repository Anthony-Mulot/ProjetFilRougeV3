
package com.projetjava.appli.dao;

import com.projetjava.appli.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDAO extends JpaRepository<Produit,Integer> {
}