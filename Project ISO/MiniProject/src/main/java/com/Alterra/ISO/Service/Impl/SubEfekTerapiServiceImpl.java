package com.Alterra.ISO.Service.Impl;

import com.Alterra.ISO.Model.SubEfekTerapi;
import com.Alterra.ISO.Repository.SubEfekTerapiRepository;
import com.Alterra.ISO.Service.SubEfekTerapiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubEfekTerapiServiceImpl implements SubEfekTerapiService {
    @Autowired
    private SubEfekTerapiRepository subEfekTerapiRepository;

    @Override
    public SubEfekTerapi createSubEfekTerapi(SubEfekTerapi subEfekTerapi) {
        return subEfekTerapiRepository.save(subEfekTerapi);
    }

    @Override
    public List<SubEfekTerapi> findAllSubTerapi() {
        return (List<SubEfekTerapi>) subEfekTerapiRepository.findAll();
    }

    @Override
    public SubEfekTerapi findByIdSubTerapi(Integer id) {
        return subEfekTerapiRepository.findById(id).orElse(null);
    }

    @Override
    public SubEfekTerapi updateSubTerapi(Integer id, SubEfekTerapi subEfekTerapi) {
        Optional<SubEfekTerapi> optionalSubEfekTerapi = subEfekTerapiRepository.findById(id);
        if (optionalSubEfekTerapi.isEmpty()){
            log.warn("Cannot update sub Efek Terapi with {} because not found", id);
            return null;
        }
        SubEfekTerapi subTerapiById = optionalSubEfekTerapi.get();
        subTerapiById.setNamaSubEfek(subEfekTerapi.getNamaSubEfek());
        subTerapiById.setDeskripsiSubEfek(subEfekTerapi.getDeskripsiSubEfek());
        return subEfekTerapiRepository.save(subTerapiById);    }

    @Override
    public void deleteSubTerapi(Integer id) {
        subEfekTerapiRepository.deleteById(id);
    }
}
