package com.br.joao.buy.apijoaobuy.controllers;

import com.br.joao.buy.apijoaobuy.model.Usuario;
import com.br.joao.buy.apijoaobuy.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionarUsario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

}
