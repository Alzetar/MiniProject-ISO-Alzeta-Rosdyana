package com.Alterra.ISO.Service;

import com.Alterra.ISO.Model.EfekTerapi;

import java.util.List;

public interface EfekTerapiService {
    EfekTerapi create(EfekTerapi efekTerapi);
    List<EfekTerapi> findAll();
    EfekTerapi findById(Integer id);
    EfekTerapi update(Integer id, EfekTerapi efekTerapi);
    void delete(Integer id);
}
