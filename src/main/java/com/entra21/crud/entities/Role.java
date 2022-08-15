package com.entra21.crud.entities;

public enum Role {

    ADMIN("ADMIN"),
    USER("USER");

    private String name;

    private Role(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    
    
}
