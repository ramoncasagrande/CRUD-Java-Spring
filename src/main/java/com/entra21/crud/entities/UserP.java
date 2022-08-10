package com.entra21.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//Cria a Tabela do Banco de Dados
@Entity
public class UserP {

    //Cria chave primária
    @Id
    //Gera o numero de Id com incremento (id++)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //Verifica se o campo não está vazio ou apenas espaços em branco
    @NotBlank
    private String name;

    private String login;

    //Verifica se o email tem formato válido
    @Email(message = "deve ser um endereço de e-mail válido")
    @NotBlank
    private String email;

    private String password;
    
    //padrão de construtor vázio
    @Deprecated
    public UserP(){
    }
    //força a passagem de parametro de pelo menos um atributo
    public UserP (String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    //hashCode só do atributo id
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    //equals só do atriibuto id
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserP other = (UserP) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
