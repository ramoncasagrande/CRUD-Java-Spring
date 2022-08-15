package com.entra21.crud.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entra21.crud.entities.UserP;
import com.entra21.crud.entities.UserRepository;

@Service("UserDetailsService")
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserP userp = userRepository.findByLogin(login);
        if (userp != null){
            SimpleGrantedAuthority authority =  new SimpleGrantedAuthority(userp.getRole());
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(authority);
            User user = new User(userp.getLogin(), userp.getPassword(), authorities);
            return user;

        }
        return null;
    }
    
}
