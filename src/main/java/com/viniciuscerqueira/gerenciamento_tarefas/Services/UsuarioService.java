package com.viniciuscerqueira.gerenciamento_tarefas.Services;


import com.viniciuscerqueira.gerenciamento_tarefas.Entitys.Usuario;
import com.viniciuscerqueira.gerenciamento_tarefas.Repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario) {
        validarUsernameUnico(usuario.getUsername());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id){
        return  usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    }

    public Usuario buscarPorUsername(String username){
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    }

    public void deletarUsuario(Integer id){
        validarExistenciaUsuario(id);
        usuarioRepository.deleteById(id);

    }

    public Usuario atualizarUsuario(Integer id, Usuario dadosAtualizados){
        validarExistenciaUsuario(id);
        Usuario usuarioExistente = buscarPorId(id);
        usuarioExistente.setUsername(dadosAtualizados.getUsername());
        usuarioExistente.setSenha((dadosAtualizados.getSenha()));
        return usuarioRepository.save(usuarioExistente);

    }


    private void validarUsernameUnico(String username) {
        if (usuarioRepository.existsByUsername(username)) {
            throw new RuntimeException("Username já está em uso");
        }
    }

    private void validarExistenciaUsuario(Integer id){
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

}
