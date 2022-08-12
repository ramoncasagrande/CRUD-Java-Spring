package com.entra21.crud;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


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
                .permitAll();                   ////Permite acesso ao fomulario de logout a todos
    }
    
}
