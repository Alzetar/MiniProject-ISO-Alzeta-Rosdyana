package com.Alterra.ISO.Service.Impl;

import com.Alterra.ISO.DTO.AddToObatDto;
import com.Alterra.ISO.Model.EfekTerapi;
import com.Alterra.ISO.Model.GolonganObat;
import com.Alterra.ISO.Model.Obat;
import com.Alterra.ISO.Model.ObatGenerik;
import com.Alterra.ISO.Repository.ObatRepository;
import com.Alterra.ISO.Service.ObatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ObatServiceImpl implements ObatService {
    @Autowired
    private ObatRepository obatRepository;

    @Autowired
    private EfekTerapiServiceImpl efekTerapiService;

    @Autowired
    private GolonganObatServiceImpl golonganObatService;

    @Autowired
    private ObatGenerikServiceImpl obatGenerikService;

//    @Override
//    public Obat create(Obat obat) {
//        return obatRepository.save(obat);
//    }
    @Override
    public Obat create(AddToObatDto addToObatDto){

//        EfekTerapi efekTerapi = efekTerapiService.findById(addToObatDto.getIdEfekTerapi());
//        GolonganObat golonganObat = golonganObatService.findByIdGolObat(addToObatDto.getIdEfekTerapi());
//        ObatGenerik obatGenerik = obatGenerikService.findByIdGenerik(addToObatDto.getIdEfekTerapi());

        Obat obat = new Obat();
//        obat.setEfekTerapi(addToObatDto.getIdEfekTerapi());
//        obat.setGolonganObat(addToObatDto.getIdGolonganObat());
//        obat.setObatGenerik(addToObatDto.getIdObatGenerik());
//        obat.setId(obat.getId());
        obat.setNamaObat(addToObatDto.getNamaObat());
        obat.setIndikasi(addToObatDto.getIndikasi());
        obat.setKontraIndikasi(addToObatDto.getKontraIndikasi());
        obat.setEfekSamping(addToObatDto.getEfekSamping());
        obat.setDosis(addToObatDto.getDosis());

        return obatRepository.save(obat);
    }


    @Override
    public List<Obat> findAll() {
        return (List<Obat>) obatRepository.findAll();
    }

    @Override
    public Obat findById(Integer id) {
        return obatRepository.findById(id).orElse(null);
    }

    @Override
    public Obat update(Integer id, Obat obat) {
        Optional<Obat> optionalObat = obatRepository.findById(id);
        if (optionalObat.isEmpty()){
            log.warn("Cannot update obat with {} because not found", id);
            return null;
        }
        Obat obatById = optionalObat.get();
        obatById.setNamaObat(obat.getNamaObat());
        obatById.setIndikasi(obat.getIndikasi());
        obatById.setKontraIndikasi(obat.getKontraIndikasi());
        obatById.setEfekSamping(obat.getEfekSamping());
        obatById.setDosis(obat.getDosis());
        return obatRepository.save(obatById);    }

    @Override
    public void delete(Integer id) {
        obatRepository.deleteById(id);
    }
}
