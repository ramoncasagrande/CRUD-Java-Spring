package com.entra21.crud;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.entra21.crud.entities.UserP;
import com.entra21.crud.entities.UserRepository;


@Component
@Transactional
public class InitialPopulation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        
        UserP user = new UserP("Ramon");
        
        userRepository.save(user);
        
    }
    
}
