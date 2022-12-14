package com.entra21.crud.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.entra21.crud.entities.UserP;
import com.entra21.crud.entities.UserRepository;

@Controller
public class UserController {

    //cria uma instancia do objeto
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("listUsers", userRepository.findAll());//chama o objeto instanciado com a annotation autowired
        return "users/index";
    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") UserP user){
        return "users/form";
    }
    
    @PostMapping("/users/add")  //Anotação para validar os dados
    public String saveUser(@Valid @ModelAttribute("user") UserP user, BindingResult bindingResult){
        //Verifica se possui erros de validação
        if (bindingResult.hasErrors()){
            return "users/form";
        }
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

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") long id){
        
        Optional<UserP> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()){
            throw new IllegalArgumentException("Usuário Inválido");
        }
        userRepository.delete(userOpt.get());
        return "redirect:/users";
    }

}
