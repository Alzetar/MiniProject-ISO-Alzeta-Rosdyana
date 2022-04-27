package com.alterra.ISO.Service;

import com.alterra.ISO.Model.EfekTerapi;
import com.alterra.ISO.Model.Obat;

import java.util.List;

public interface TerapiService {
    EfekTerapi create(EfekTerapi efekTerapi);
    List<EfekTerapi> findAll();
    EfekTerapi findById(Integer id_efek_terapi);
    EfekTerapi update(Integer id_efek_terapi, EfekTerapi efekTerapi);
    void delete(Integer id_efek_terapi);
}
