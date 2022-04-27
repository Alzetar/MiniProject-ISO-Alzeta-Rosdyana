package com.alterra.ISO.Service;

import com.alterra.ISO.Model.GolonganObat;
import com.alterra.ISO.Model.Obat;

import java.util.List;

public interface GolonganService {
    GolonganObat createGolongan(GolonganObat golongan);
    List<GolonganObat> findAllGolObat();
    GolonganObat findByIdGolObat(Integer id_golongan);
    GolonganObat updateGolObat(Integer id_golongan, GolonganObat golongan);
    void deleteGolObat(Integer id_golongan);
}
