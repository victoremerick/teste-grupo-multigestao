package br.victoremerick.testegrupomultigestao.database.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numeroProcesso;

    @OneToMany(mappedBy = "processo")
    private List<Reu> reus;

}
