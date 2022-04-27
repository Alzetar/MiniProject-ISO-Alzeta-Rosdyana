package com.alterra.ISO.Service.Impl;

import com.alterra.ISO.Model.Obat;
import com.alterra.ISO.Model.ObatGenerik;
import com.alterra.ISO.Repository.GenerikRepository;
import com.alterra.ISO.Service.GenerikService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GenerikServiceImpl implements GenerikService {
    @Autowired
    private GenerikRepository generikRepository;

    @Override
    public ObatGenerik createGenerik(ObatGenerik generik) {
        return generikRepository.save(generik);
    }

    @Override
    public List<ObatGenerik> findAllObatGenerik() {
        return (List<ObatGenerik>) generikRepository.findAll();
    }

    @Override
    public ObatGenerik findByIdGenerik(Integer id_generik) {
        return generikRepository.findById(id_generik).orElse(null);
    }

    @Override
    public ObatGenerik updateObatGenerik(Integer id_generik, ObatGenerik generik) {
        Optional<ObatGenerik> optionalObatGenerik = generikRepository.findById(id_generik);
        if (optionalObatGenerik.isEmpty()){
            log.warn("Cannot update obat with {} because not found", id_generik);
            return null;
        }
        ObatGenerik generikById = optionalObatGenerik.get();
        generikById.setNama_obat_generik(generik.getNama_obat_generik());
        return generikRepository.save(generikById);
    }

    @Override
    public void deleteObatGenerik(Integer id_generik) {
        generikRepository.deleteById(id_generik);
    }
}
