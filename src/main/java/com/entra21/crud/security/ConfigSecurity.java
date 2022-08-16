package com.entra21.crud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration      //indica que a classe fonecerá configurações para o springboot
@EnableWebSecurity  //indica que a classe fonecerá configurações de segurança
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

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
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(PasswordEncoder());

    }
 
    @Bean
    public PasswordEncoder PasswordEncoder() {
        return new BCryptPasswordEncoder();   //Parâmetro de força de criptografia
    }
}
