package com.br.joao.buy.apijoaobuy.model;

public enum TipoUsuario {
    ADMIN("admin"),
    USER("user");

    private String tipo;

    TipoUsuario(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }
}
