package com.entra21.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    
    @PostMapping("/users/add")
    public String saveUser(@ModelAttribute("user") UserP user){
        userRepository.save(user);
        return "redirect:/users";
    }


    @GetMapping("/users/{id}")
    public String editUser(@PathVariable("id") long id, Model model){
        Optional<UserP> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()){
            throw new IllegalArgumentException("Usuário Inválido");
        }
        model.addAttribute("user", userOpt.get());
        return "/users/form";
    }


}
