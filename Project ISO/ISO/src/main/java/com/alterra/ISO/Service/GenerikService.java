package com.alterra.ISO.Service;

import com.alterra.ISO.Model.Obat;
import com.alterra.ISO.Model.ObatGenerik;

import java.util.List;

public interface GenerikService {
    ObatGenerik createGenerik(ObatGenerik generik);
    List<ObatGenerik> findAllObatGenerik();
    ObatGenerik findByIdGenerik(Integer id_generik);
    ObatGenerik updateObatGenerik(Integer id_generik, ObatGenerik generik);
    void deleteObatGenerik(Integer id_generik);
}
