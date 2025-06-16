package com.viniciuscerqueira.gerenciamento_tarefas.Repositorys;

import com.viniciuscerqueira.gerenciamento_tarefas.Entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);


}
