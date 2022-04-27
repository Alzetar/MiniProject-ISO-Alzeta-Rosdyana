package com.alterra.ISO.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class GolonganObat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_golongan;
    private String nama_golongan;
    private String deskripsi_golongan;
}
