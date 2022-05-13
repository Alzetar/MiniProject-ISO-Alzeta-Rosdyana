package com.Alterra.ISO.Service;

import com.Alterra.ISO.Model.ObatGenerik;

import java.util.List;

public interface ObatGenerikService {
    ObatGenerik createGenerik(ObatGenerik generik);
    List<ObatGenerik> findAllObatGenerik();
    ObatGenerik findByIdGenerik(Integer id);
    ObatGenerik updateObatGenerik(Integer id, ObatGenerik generik);
    void deleteObatGenerik(Integer id);
}
