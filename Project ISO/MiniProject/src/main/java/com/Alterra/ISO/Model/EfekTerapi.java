package com.Alterra.ISO.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "efek_terapi")
public class EfekTerapi {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @OneToMany
    @Column(name = "Id_Sub_Efek_Terapi")
    private Set<SubEfekTerapi> idsubEfekTerapi;

    @Column(name = "Nama_Efek_Terapi", length = 75)
    private String namaEfekTerapi;

    @Column(name = "Deskripsi_Efek_Terapi")
    private Character deskripsiEfekTerapi;

}