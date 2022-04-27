package com.alterra.ISO.Service.Impl;

import com.alterra.ISO.Model.EfekTerapi;
import com.alterra.ISO.Model.SubEfekTerapi;
import com.alterra.ISO.Repository.TerapiRepository;
import com.alterra.ISO.Service.TerapiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TerapiServiceImpl implements TerapiService {
    @Autowired
    private TerapiRepository terapiRepository;

    @Override
    public EfekTerapi create(EfekTerapi efekTerapi) {
        return terapiRepository.save(efekTerapi);
    }

    @Override
    public List<EfekTerapi> findAll() {
        return (List<EfekTerapi>) terapiRepository.findAll();
    }

    @Override
    public EfekTerapi findById(Integer id_efek_terapi) {
        return terapiRepository.findById(id_efek_terapi).orElse(null);
    }

    @Override
    public EfekTerapi update(Integer id_efek_terapi, EfekTerapi efekTerapi) {
        Optional<EfekTerapi> optionalEfekTerapi = terapiRepository.findById(id_efek_terapi);
        if (optionalEfekTerapi.isEmpty()){
            log.warn("Cannot update obat with {} because not found", id_efek_terapi);
            return null;
        }
        EfekTerapi terapiById = optionalEfekTerapi.get();
        terapiById.setNama_efek_terapi(efekTerapi.getNama_efek_terapi());
        terapiById.setDeskripsi_efek_terapi(efekTerapi.getDeskripsi_efek_terapi());
        return terapiRepository.save(terapiById);
    }

    @Override
    public void delete(Integer id_efek_terapi) {
        terapiRepository.deleteById(id_efek_terapi);
    }
}
