package com.Alterra.ISO.Service.Impl;

import com.Alterra.ISO.Model.EfekTerapi;
import com.Alterra.ISO.Repository.EfekTerapiRepository;
import com.Alterra.ISO.Service.EfekTerapiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EfekTerapiServiceImpl implements EfekTerapiService {
    @Autowired
    private EfekTerapiRepository efekTerapiRepository;

    @Override
    public EfekTerapi create(EfekTerapi efekTerapi) {
        return efekTerapiRepository.save(efekTerapi);
    }

    @Override
    public List<EfekTerapi> findAll() {
        return (List<EfekTerapi>) efekTerapiRepository.findAll();
    }

    @Override
    public EfekTerapi findById(Integer id) {
        Optional<EfekTerapi> optionalEfekTerapi = efekTerapiRepository.findById(id);
        if (optionalEfekTerapi.isEmpty()) {
            log.warn("Cannot find efek terapi with {} because not found", id);
            return null;
        }
        return optionalEfekTerapi.get();
    }

    @Override
    public EfekTerapi update(Integer id, EfekTerapi efekTerapi) {
        Optional<EfekTerapi> optionalEfekTerapi = efekTerapiRepository.findById(id);
        if (optionalEfekTerapi.isEmpty()){
            log.warn("Cannot update efek terapi with {} because not found", id);
            return null;
        }
        EfekTerapi terapiById = optionalEfekTerapi.get();
        terapiById.setNamaEfekTerapi(efekTerapi.getNamaEfekTerapi());
        terapiById.setDeskripsiEfekTerapi(efekTerapi.getDeskripsiEfekTerapi());
        return efekTerapiRepository.save(terapiById);    }

    @Override
    public void delete(Integer id) {
        efekTerapiRepository.deleteById(id);
    }
}
