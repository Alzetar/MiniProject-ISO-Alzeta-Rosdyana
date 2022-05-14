package com.Alterra.ISO.Service;

import com.Alterra.ISO.DTO.AddToObatDto;
import com.Alterra.ISO.Model.Obat;

import java.util.List;

public interface ObatService {
//    Obat create(Obat obat);
    Obat create(AddToObatDto addToObatDto);
    List<Obat> findAll();
    Obat findById(Integer id);
    Obat update(Integer id, Obat obat);
    void delete(Integer id);
}
