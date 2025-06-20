package com.viniciuscerqueira.gerenciamento_tarefas.Entitys;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "table_tarefa")
public class Tarefa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao_tarefa", nullable = false, length = 250)
    private String descricao;

    @Column()
    private LocalDate dataRealizacao;

    @JoinColumn(name = "responsavel_tarefa",nullable = false)
    @ManyToOne
    private Usuario responsavel;


    public Tarefa(String descricao, LocalDate dataRealizacao, Usuario responsavel) {
        this.descricao = descricao;
        this.dataRealizacao = dataRealizacao;
        this.responsavel = responsavel;
    }
}
