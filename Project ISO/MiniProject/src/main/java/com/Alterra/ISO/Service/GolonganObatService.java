package com.Alterra.ISO.Service;

import com.Alterra.ISO.Model.GolonganObat;

import java.util.List;

public interface GolonganObatService {
    GolonganObat createGolongan(GolonganObat golongan);
    List<GolonganObat> findAllGolObat();
    GolonganObat findByIdGolObat(Integer id);
    GolonganObat updateGolObat(Integer id, GolonganObat golongan);
    void deleteGolObat(Integer id);
}
