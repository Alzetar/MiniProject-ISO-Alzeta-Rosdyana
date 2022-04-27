package com.alterra.ISO.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ObatGenerik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_generik;
    private String nama_obat_generik;
}
