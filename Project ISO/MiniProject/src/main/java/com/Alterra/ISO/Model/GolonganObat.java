package com.Alterra.ISO.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "golongan_obat")
public class GolonganObat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Nama_Golongan", length = 50)
    private String namaGolongan;

    @Column(name = "Deskripsi_Golongan")
    private String deskripsiGolongan;

}