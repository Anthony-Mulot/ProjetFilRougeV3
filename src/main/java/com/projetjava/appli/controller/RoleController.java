package com.projetjava.appli.controller;

import com.projetjava.appli.dao.RoleDAO;
import com.projetjava.appli.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RoleController {

    @Autowired
    RoleDAO roleDAO;

    @GetMapping("/liste-role")
    public String listeRole(Model model) {


        model.addAttribute("titre", "liste des roles");
        model.addAttribute("roles", roleDAO.findAll());

        return "liste-role";
    }

    @GetMapping({"/modo/edit-role", "/modo/edit-role/{id}"})
    public String editRole(Model model, @PathVariable Optional<Integer> id) {


        Role role;

        if(id.isPresent()){
            role = roleDAO.findById(id.get()).orElse(null);
        }else {
            role = new Role();
        }

        model.addAttribute("titre", id.isPresent() ? "Edit Roles" : "Nouvelle role");
        model.addAttribute("role", role);

        return "edit-role";
    }

    @PostMapping("/modo/edit-role")
    public String editRole(@ModelAttribute("role") Role role){

        role = roleDAO.saveAndFlush(role);

        return "redirect:/liste-role";
    }

    @GetMapping("/admin/suppression-role/{id}")
    public String delRole(@PathVariable Integer id){
        roleDAO.deleteById(id);

        return "redirect:/liste-role";
    }
}

