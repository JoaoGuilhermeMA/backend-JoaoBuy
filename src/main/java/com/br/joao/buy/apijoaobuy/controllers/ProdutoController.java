package com.br.joao.buy.apijoaobuy.controllers;

import com.br.joao.buy.apijoaobuy.model.Produto;
import com.br.joao.buy.apijoaobuy.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/nome-{nome}")
    public List<Produto> listarPeloNome(@PathVariable String nome){
            return produtoRepository.findByNome(nome);
    }

    @GetMapping("/anime-{anime}")
    public List<Produto> listarPeloAnime(@PathVariable String anime){
        return produtoRepository.findByAnimeProduto(anime);
    }

    @GetMapping("/tipo-{tipo}")
    public List<Produto> listarPeloTipo(@PathVariable String tipo){
        return produtoRepository.findByTipo(tipo);
    }

    @GetMapping("/preco-{preco}")
    public List<Produto> listarPeloPreco(@PathVariable Integer preco){
        return produtoRepository.findByPrecoUnidade(preco);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @GetMapping("/{id}")
    public Optional<Produto> listaId(@PathVariable Long id){
        return produtoRepository.findById(id);
    }

    @DeleteMapping("/excluir-{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/atualizar-{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto2) {
        Optional<Produto> produto1 = produtoRepository.findById(id);
        Produto produto = produto1.get();
        produto.setNome(produto2.getNome());
        produto.setTipo(produto2.getTipo());
        produto.setQuantidade(produto2.getQuantidade());
        produto.setPrecoUnidade(produto2.getPrecoUnidade());
        produto.setAnimeProduto(produto2.getAnimeProduto());
        produto.setUrlFoto(produto2.getUrlFoto());

        Produto produtoAtualizado = produtoRepository.save(produto);
        return ResponseEntity.ok(produtoAtualizado);
    }
}
