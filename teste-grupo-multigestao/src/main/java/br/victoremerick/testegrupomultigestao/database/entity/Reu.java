package br.victoremerick.testegrupomultigestao.database.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Reu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @ManyToOne
    private Processo processo;
}
