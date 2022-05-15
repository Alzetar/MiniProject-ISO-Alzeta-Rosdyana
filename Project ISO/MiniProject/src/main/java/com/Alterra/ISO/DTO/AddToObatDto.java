package com.Alterra.ISO.DTO;

import lombok.Data;

@Data
public class AddToObatDto {
    private Integer id;
    private Integer idEfekTerapi;
    private Integer idGolonganObat;
    private Integer idObatGenerik;
    private String namaObat;
    private String indikasi;
    private String kontraIndikasi;
    private String efekSamping;
    private String dosis;

}
