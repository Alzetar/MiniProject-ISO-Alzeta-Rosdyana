package com.alterra.ISO.Service;

import com.alterra.ISO.Model.Obat;
import com.alterra.ISO.Model.SubEfekTerapi;

import java.util.List;

public interface SubTerapiService {
    SubEfekTerapi createSubEfekTerapi(SubEfekTerapi subEfekTerapi);
    List<SubEfekTerapi> findAllSubTerapi();
    SubEfekTerapi findByIdSubTerapi(Integer id_sub_efek);
    SubEfekTerapi updateSubTerapi(Integer id_sub_efek, SubEfekTerapi subEfekTerapi);
    void deleteSubTerapi(Integer id_sub_efek);
}
