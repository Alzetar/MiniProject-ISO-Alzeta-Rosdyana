package com.alterra.ISO.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EfekTerapi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_efek_terapi;
    private String nama_efek_terapi;
    private String deskripsi_efek_terapi;

    @OneToMany
    @JoinColumn(name = "id_sub_efek", nullable = false)
    private SubEfekTerapi subEfekTerapi;
}
