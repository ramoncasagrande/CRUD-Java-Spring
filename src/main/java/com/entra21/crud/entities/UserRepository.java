package com.entra21.crud.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//cria uma interface e implementa o repositório do JPA 
@Repository
public interface UserRepository extends JpaRepository<UserP, Long>{

    UserP findByLogin(String login);
    
}
