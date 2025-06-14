package com.viniciuscerqueira.gerenciamento_tarefas.Entitys;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "table_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column()
    private Integer id;

    @Column(length = 10, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String senha;

    @Column()
    @OneToMany
    private List<Tarefa> tarefas;

}
