package com.Alterra.ISO.Service;

import com.Alterra.ISO.Model.SubEfekTerapi;

import java.util.List;

public interface SubEfekTerapiService {
    SubEfekTerapi createSubEfekTerapi(SubEfekTerapi subEfekTerapi);
    List<SubEfekTerapi> findAllSubTerapi();
    SubEfekTerapi findByIdSubTerapi(Integer id);
    SubEfekTerapi updateSubTerapi(Integer id, SubEfekTerapi subEfekTerapi);
    void deleteSubTerapi(Integer id);
}
