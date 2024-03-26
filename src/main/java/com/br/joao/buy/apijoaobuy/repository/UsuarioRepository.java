package com.br.joao.buy.apijoaobuy.repository;

import com.br.joao.buy.apijoaobuy.model.Produto;
import com.br.joao.buy.apijoaobuy.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
