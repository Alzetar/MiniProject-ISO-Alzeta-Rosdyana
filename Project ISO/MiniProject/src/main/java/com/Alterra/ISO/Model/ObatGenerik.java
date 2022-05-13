package com.Alterra.ISO.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "obat_generik")
public class ObatGenerik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Nama_Obat_Generik", length = 75)
    private String namaObatGenerik;
}