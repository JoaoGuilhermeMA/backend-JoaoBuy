package com.br.joao.buy.apijoaobuy.repository;

import com.br.joao.buy.apijoaobuy.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNome(String nome);
    List<Produto> findByTipo(String tipo);
    List<Produto> findByQuantidade(Integer quantidade);
    List<Produto> findByPrecoUnidade(Integer precoUnidade);
    List<Produto> findByAnimeProduto(String animeProduto);
}
