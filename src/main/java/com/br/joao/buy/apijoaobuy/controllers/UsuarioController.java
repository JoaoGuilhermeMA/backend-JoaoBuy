package com.br.joao.buy.apijoaobuy.controllers;

import com.br.joao.buy.apijoaobuy.model.AuthenticationDTQ;
import com.br.joao.buy.apijoaobuy.model.RegisterDTO;
import com.br.joao.buy.apijoaobuy.model.Usuario;
import com.br.joao.buy.apijoaobuy.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autenticacao")
public class UsuarioController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTQ data ){
        var usuarioSenha = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usuarioSenha);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/registrar")
    public ResponseEntity registrer(@RequestBody @Validated RegisterDTO data){
        if (this.usuarioRepository.findByEmail(data.email()) != null){
            return ResponseEntity.badRequest().build();
        }
        String senhaCriptografada = new BCryptPasswordEncoder().encode(data.senha());
        Usuario usuario = new Usuario(data.email(), senhaCriptografada, data.role());
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

}
