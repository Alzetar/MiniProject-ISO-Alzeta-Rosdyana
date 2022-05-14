package com.Alterra.ISO.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "obat")
public class Obat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Efek_Terapi")
    private EfekTerapi efekTerapi;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Golongan_obat")
    private GolonganObat golonganObat;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_Obat_Generik")
    private ObatGenerik obatGenerik;

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