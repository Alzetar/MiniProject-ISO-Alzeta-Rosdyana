package com.alterra.ISO.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Obat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_obat;
    private String nama_obat;
    private String indikasi;
    private String kontra_indikasi;
    private String efek_samping;
    private String dosis;

    @ManyToOne
    @JoinColumn(name = "id_efek_terapi", nullable = false)
    private EfekTerapi efekTerapi;

    @ManyToOne
    @JoinColumn(name = "id_golongan", nullable = false)
    private GolonganObat golonganObat;

    @OneToMany
    @JoinColumn(name = "id_generik", nullable = false)
    private ObatGenerik obatGenerik;
}
