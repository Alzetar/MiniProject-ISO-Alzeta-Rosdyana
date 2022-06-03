package com.Alterra.ISO.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "efek_terapi")
public class EfekTerapi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Nama_Efek_Terapi", length = 75)
    private String namaEfekTerapi;

    @Column(name = "Deskripsi_Efek_Terapi")
    private String deskripsiEfekTerapi;

}