package com.alterra.ISO.Service.Impl;

import com.alterra.ISO.Model.Obat;
import com.alterra.ISO.Repository.ObatRepository;
import com.alterra.ISO.Service.ObatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ObatServiceImpl implements ObatService {
    @Autowired
    private ObatRepository obatRepository;

    @Override
    public Obat create(Obat obat) {
        return obatRepository.save(obat);
    }

    @Override
    public List<Obat> findAll() {
        return (List<Obat>) obatRepository.findAll();
    }

    @Override
    public Obat findById(Integer id_obat) {
        return obatRepository.findById(id_obat).orElse(null);
    }

    @Override
    public Obat update(Integer id_obat, Obat obat) {
        Optional<Obat> optionalObat = obatRepository.findById(id_obat);
        if (optionalObat.isEmpty()){
            log.warn("Cannot update obat with {} because not found", id_obat);
            return null;
        }
        Obat obatById = optionalObat.get();
        obatById.setNama_obat(obat.getNama_obat());
        obatById.setIndikasi(obat.getIndikasi());
        obatById.setKontra_indikasi(obat.getKontra_indikasi());
        obatById.setEfek_samping(obat.getEfek_samping());
        obatById.setDosis(obat.getDosis());
        return obatRepository.save(obatById);
    }

    @Override
    public void delete(Integer id_obat) {
        obatRepository.deleteById(id_obat);
    }
}
