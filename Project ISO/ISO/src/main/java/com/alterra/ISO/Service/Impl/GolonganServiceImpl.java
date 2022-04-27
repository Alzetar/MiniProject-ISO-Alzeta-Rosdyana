package com.alterra.ISO.Service.Impl;


import com.alterra.ISO.Model.GolonganObat;
import com.alterra.ISO.Model.ObatGenerik;
import com.alterra.ISO.Repository.GolonganRepository;
import com.alterra.ISO.Service.GolonganService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class GolonganServiceImpl implements GolonganService {
    @Autowired
    private GolonganRepository golonganRepository;

    @Override
    public GolonganObat createGolongan(GolonganObat golongan) {
        return golonganRepository.save(golongan);
    }

    @Override
    public List<GolonganObat> findAllGolObat() {
        return (List<GolonganObat>) golonganRepository.findAll();
    }

    @Override
    public GolonganObat findByIdGolObat(Integer id_golongan) {
        return golonganRepository.findById(id_golongan).orElse(null);
    }

    @Override
    public GolonganObat updateGolObat(Integer id_golongan, GolonganObat golongan) {
        Optional<GolonganObat> optionalGolonganObat = golonganRepository.findById(id_golongan);
        if (optionalGolonganObat.isEmpty()){
            log.warn("Cannot update obat with {} because not found", id_golongan);
            return null;
        }
        GolonganObat golonganById = optionalGolonganObat.get();
        golonganById.setNama_golongan(golongan.getNama_golongan());
        golonganById.setDeskripsi_golongan(golongan.getDeskripsi_golongan());
        return golonganRepository.save(golonganById);
    }

    @Override
    public void deleteGolObat(Integer id_golongan) {
        golonganRepository.deleteById(id_golongan);
    }
}
