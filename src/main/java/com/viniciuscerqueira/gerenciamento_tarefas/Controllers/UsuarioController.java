package com.viniciuscerqueira.gerenciamento_tarefas.Controllers;


import com.viniciuscerqueira.gerenciamento_tarefas.Entitys.Usuario;
import com.viniciuscerqueira.gerenciamento_tarefas.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController{

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
        }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario>  buscarUsuarioPorId(Integer id){
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorUsername(String username){
        Usuario usuario = usuarioService.buscarPorUsername(username);
        return ResponseEntity.ok(usuario);

        }
    }




