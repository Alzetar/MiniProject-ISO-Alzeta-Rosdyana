package com.Alterra.ISO.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sub_efek_terapi")
public class SubEfekTerapi {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Nama_Sub_Efek", length = 75)
    private String namaSubEfek;

    @Column(name = "Deskripsi_Sub_Efek")
    private Character deskripsiSubEfek;

}