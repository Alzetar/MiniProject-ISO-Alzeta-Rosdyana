package com.Alterra.ISO.DTO;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class AddToObatDto {
    private Integer idEfekTerapi;
    private Integer idGolonganObat;
    private Integer idObatGenerik;
    private String namaObat;
    private String indikasi;
    private String kontraIndikasi;
    private String efekSamping;
    private String dosis;

}
