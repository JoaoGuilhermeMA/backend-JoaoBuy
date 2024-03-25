package com.br.joao.buy.apijoaobuy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private Integer quantidade;
    @Column(nullable = false)
    private Integer precoUnidade;
    @Column(nullable = false)
    private String animeProduto;
    @Column(nullable = false)
    private String urlFoto;

}
