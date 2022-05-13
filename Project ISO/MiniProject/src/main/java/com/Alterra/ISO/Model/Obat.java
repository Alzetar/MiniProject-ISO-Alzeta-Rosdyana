package com.Alterra.ISO.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "obat")
public class Obat {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Efek_Terapi")
    private EfekTerapi idEfekTerapi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Golongan_obat")
    private GolonganObat idGolonganObat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Obat_Generik")
    private ObatGenerik idObatGenerik;

    @Column(name = "Nama_Obat", length = 75)
    private String namaObat;

    @Column(name = "Indikasi", length = 100)
    private String indikasi;

    @Column(name = "Kontra_Indikasi", length = 75)
    private String kontraIndikasi;

    @Column(name = "Efek_Samping", length = 100)
    private String efekSamping;

    @Column(name = "Dosis", length = 50)
    private String dosis;



}