package com.viniciuscerqueira.gerenciamento_tarefas.Repositorys;

import com.viniciuscerqueira.gerenciamento_tarefas.Entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByUsername(String username);
}
