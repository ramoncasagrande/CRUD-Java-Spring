package com.entra21.crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration      //indica que a classe fonecerá configurações para o springboot
@EnableWebSecurity  //indica que a classe fonecerá configurações de segurança
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()                //Autoriza requisições
                .anyRequest().authenticated()   //Qualquer requisição deverá ser autenticada
                .and()
            .formLogin()
                .permitAll()                    //Permite acesso ao fomulario de login a todos
                .and()
            .logout()
                .permitAll();                   //Permite acesso ao fomulario de logout a todos
    }
    
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {     //verifica os logins
        UserDetails user = User.withDefaultPasswordEncoder()
                            .username("ramon")
                            .password("ramon")
                            .roles("USER")
                            .build();
        return new InMemoryUserDetailsManager(user);
    }
}
