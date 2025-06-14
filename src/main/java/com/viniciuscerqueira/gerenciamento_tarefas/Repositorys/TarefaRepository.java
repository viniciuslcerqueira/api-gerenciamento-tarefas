package com.viniciuscerqueira.gerenciamento_tarefas.Repositorys;

import com.viniciuscerqueira.gerenciamento_tarefas.Entitys.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
