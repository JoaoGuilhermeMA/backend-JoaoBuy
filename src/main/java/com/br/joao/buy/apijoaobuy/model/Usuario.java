package com.br.joao.buy.apijoaobuy.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
}
