package com.alterra.ISO.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SubEfekTerapi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_sub_efek;
    private String nama_sub_efek;
    private String deskripsi_sub_efek;

}
