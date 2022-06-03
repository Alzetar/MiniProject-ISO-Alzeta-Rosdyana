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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "Nama_Obat")
    private String namaObat;

    @Column(name = "Indikasi")
    private String indikasi;

    @Column(name = "Kontra_Indikasi")
    private String kontraIndikasi;

    @Column(name = "Efek_Samping")
    private String efekSamping;

    @Column(name = "Dosis")
    private String dosis;



}