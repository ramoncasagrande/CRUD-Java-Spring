package com.entra21.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.entra21.crud.entities.UserP;
import com.entra21.crud.entities.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("listUsers", userRepository.findAll());
        return "users/index";
    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") UserP user){
        return "users/form";
    }
    
}
