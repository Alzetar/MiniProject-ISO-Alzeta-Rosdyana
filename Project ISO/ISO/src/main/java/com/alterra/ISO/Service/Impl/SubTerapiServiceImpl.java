package com.alterra.ISO.Service.Impl;


import com.alterra.ISO.Model.ObatGenerik;
import com.alterra.ISO.Model.SubEfekTerapi;
import com.alterra.ISO.Repository.SubTerapiRepository;
import com.alterra.ISO.Service.SubTerapiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubTerapiServiceImpl implements SubTerapiService {
    @Autowired
    private SubTerapiRepository subTerapiRepository;

    @Override
    public SubEfekTerapi createSubEfekTerapi(SubEfekTerapi subEfekTerapi) {
        return subTerapiRepository.save(subEfekTerapi);
    }

    @Override
    public List<SubEfekTerapi> findAllSubTerapi() {
        return (List<SubEfekTerapi>) subTerapiRepository.findAll();
    }

    @Override
    public SubEfekTerapi findByIdSubTerapi(Integer id_sub_efek) {
        return subTerapiRepository.findById(id_sub_efek).orElse(null);
    }

    @Override
    public SubEfekTerapi updateSubTerapi(Integer id_sub_efek, SubEfekTerapi subEfekTerapi) {
        Optional<SubEfekTerapi> optionalSubEfekTerapi = subTerapiRepository.findById(id_sub_efek);
        if (optionalSubEfekTerapi.isEmpty()){
            log.warn("Cannot update obat with {} because not found", id_sub_efek);
            return null;
        }
        SubEfekTerapi subTerapiById = optionalSubEfekTerapi.get();
        subTerapiById.setNama_sub_efek(subEfekTerapi.getNama_sub_efek());
        subTerapiById.setDeskripsi_sub_efek(subEfekTerapi.getDeskripsi_sub_efek());
        return subTerapiRepository.save(subTerapiById);
    }

    @Override
    public void deleteSubTerapi(Integer id_sub_efek) {
        subTerapiRepository.deleteById(id_sub_efek);
    }
}
