package com.Alterra.ISO.Service.Impl;

import com.Alterra.ISO.Model.EfekTerapi;
import com.Alterra.ISO.Model.GolonganObat;
import com.Alterra.ISO.Repository.GolonganObatRepository;
import com.Alterra.ISO.Service.GolonganObatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class GolonganObatServiceImpl implements GolonganObatService {
    @Autowired
    private GolonganObatRepository golonganObatRepository;

    @Override
    public GolonganObat createGolongan(GolonganObat golongan) {
        return golonganObatRepository.save(golongan);
    }

    @Override
    public List<GolonganObat> findAllGolObat() {
        return (List<GolonganObat>) golonganObatRepository.findAll();
    }

//    @Override
//    public GolonganObat findByIdGolObat(Integer id) {
//        return golonganObatRepository.findById(id).orElse(null);
//    }

    @Override
    public GolonganObat findByIdGolObat(Integer id) {
        Optional<GolonganObat> optionalGolonganObat = golonganObatRepository.findById(id);
        if (optionalGolonganObat.isEmpty()) {
            log.warn("Cannot find Golongan oba with {} because not found", id);
            return null;
        }
        return optionalGolonganObat.get();
    }

    @Override
    public GolonganObat updateGolObat(Integer id, GolonganObat golongan) {
        Optional<GolonganObat> optionalGolonganObat = golonganObatRepository.findById(id);
        if (optionalGolonganObat.isEmpty()){
            log.warn("Cannot update GolonganObat with {} because not found", id);
            return null;
        }
        GolonganObat golonganById = optionalGolonganObat.get();
        golonganById.setNamaGolongan(golongan.getNamaGolongan());
        golonganById.setDeskripsiGolongan(golongan.getDeskripsiGolongan());
        return golonganObatRepository.save(golonganById);
    }

    @Override
    public void deleteGolObat(Integer id) {
        golonganObatRepository.deleteById(id);
    }
}
