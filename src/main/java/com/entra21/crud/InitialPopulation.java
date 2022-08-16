package com.entra21.crud;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.entra21.crud.entities.Role;
import com.entra21.crud.entities.UserP;
import com.entra21.crud.entities.UserRepository;


@Component
@Transactional
public class InitialPopulation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        
        UserP user1 = new UserP("Ramon");
        user1.setEmail("ramon@email.com");
        user1.setLogin("ramon.c");
        user1.setPassword(encoder.encode("ramon"));
        user1.setRole(Role.ADMIN.getName());

        UserP user2 = new UserP("Josi");
        user2.setEmail("josi@email.com");
        user2.setLogin("josi.v");
        user2.setPassword(encoder.encode("123456"));
        user2.setRole(Role.USER.getName());
        
        userRepository.save(user1);
        userRepository.save(user2);


        
    }
    
}
