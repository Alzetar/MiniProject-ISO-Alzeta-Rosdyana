package com.Alterra.ISO.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "golongan_obat")
public class GolonganObat {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Nama_Golongan", length = 50)
    private String namaGolongan;

    @Column(name = "Deskripsi_Golongan")
    private Character deskripsiGolongan;

}