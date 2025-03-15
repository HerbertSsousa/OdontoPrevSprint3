package com.example.sinistros.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "funcionario")
@Data
@NoArgsConstructor
public class Funcionario {

    @Id
  //  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_seq")
 //   @SequenceGenerator(name = "funcionario_seq", sequenceName = "funcionario_seq", allocationSize = 1)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "cargo", nullable = false, length = 50)
    private String cargo;

    @Column(name = "salario", nullable = false)
    private Double salario;

    @Column(name = "data_admissao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    @Column(name = "telefone", length = 15)
    private String telefone;


    @Column(name = "email", unique = true, length = 50)
    private String email;



}
