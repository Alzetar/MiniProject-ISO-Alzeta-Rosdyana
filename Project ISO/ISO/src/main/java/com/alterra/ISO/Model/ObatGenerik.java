package com.alterra.ISO.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class ObatGenerik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_generik;
    private String nama_obat_generik;

    @ManyToMany
    @JoinColumn(name = "id_obat")
    private Set<Obat> obats;
}
