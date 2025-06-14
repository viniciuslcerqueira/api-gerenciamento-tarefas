package com.viniciuscerqueira.gerenciamento_tarefas.Services;


import com.viniciuscerqueira.gerenciamento_tarefas.Entitys.Tarefa;
import com.viniciuscerqueira.gerenciamento_tarefas.Repositorys.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(Tarefa tarefa){
        tarefa.setDataRealizacao(LocalDate.now());
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public void deletarTarefa(Integer id){
        if(!tarefaRepository.existsById(id)){
            throw new RuntimeException("Tarefa não encontrada");
        }
        tarefaRepository.deleteById(id);
    }

}
