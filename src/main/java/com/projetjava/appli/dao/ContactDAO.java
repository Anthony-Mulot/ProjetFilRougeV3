package com.projetjava.appli.dao;

import com.projetjava.appli.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDAO extends JpaRepository<Contact,Integer> {
}
