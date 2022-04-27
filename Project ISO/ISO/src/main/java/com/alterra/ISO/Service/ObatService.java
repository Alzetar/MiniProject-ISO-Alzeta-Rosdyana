package com.alterra.ISO.Service;

import com.alterra.ISO.Model.Obat;

import java.util.List;

public interface ObatService {
    Obat create(Obat obat);
    List<Obat> findAll();
    Obat findById(Integer id_obat);
    Obat update(Integer id_obat, Obat obat);
    void delete(Integer id_obat);
}
